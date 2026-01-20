// pages/chat/chat.js
const app = getApp()

Page({
  data: {
    toUserId: '',         // 接收方用户ID
    toUserName: '',       // 接收方用户名
    toUserAvatar: '',     // 接收方头像
    currentUserId: '',    // 当前用户ID
    currentUserAvatar: '',// 当前用户头像
    messages: [],         // 文字消息列表
    imageMessages: [],    // 图片消息列表
    inputValue: '',       // 输入框内容
    showEmoji: false,     // 是否显示表情面板
    loadingHistory: false,// 是否正在加载历史消息
    page: 1,              // 分页页码
    hasMoreHistory: true, // 是否有更多历史消息
    scrollTop: 0,         // 滚动位置
    showTimeDivider: true,// 是否显示时间分割线
    currentDate: null,    // 当前日期
    today: true,          // 是否是今天
    emojis: ['😀', '😃', '😄', '😁', '😆', '😅', '😂', '🤣', '😊', '😇', '🙂', '🙃', '😉', '😌', '😍', '😘'] // 表情列表
  },
  
  onLoad(options) {
    // 获取页面参数
    this.setData({
      toUserId: options.toUserId,
      toUserName: options.toUserName,
      toUserAvatar: options.toUserAvatar,
      currentUserId: app.globalData.userInfo.userId,
      currentUserAvatar: app.globalData.userInfo.avatarUrl,
      currentDate: new Date().getTime()
    })
    
    // 设置页面标题
    wx.setNavigationBarTitle({
      title: options.toUserName
    })
    
    // 加载历史消息
    this.loadHistoryMessages()
    
    // 监听新消息
    this.listenNewMessage()
    
    // 标记消息为已读
    this.markAsRead()
  },
  
  // 加载历史消息
  loadHistoryMessages() {
    if (!this.data.hasMoreHistory || this.data.loadingHistory) return
    
    this.setData({ loadingHistory: true })
    
    wx.request({
      url: 'https://your-server-domain/api/messages/history',
      method: 'GET',
      data: {
        fromUserId: this.data.currentUserId,
        toUserId: this.data.toUserId,
        page: this.data.page,
        pageSize: 20
      },
      success: res => {
        this.setData({ loadingHistory: false })
        
        if (res.data.code === 200) {
          const newMessages = res.data.data.messages || []
          const hasMore = res.data.data.hasMore
          
          // 格式化消息时间
          newMessages.forEach(msg => {
            msg.timeText = this.formatTime(msg.time)
          })
          
          // 分离文字消息和图片消息
          const textMessages = newMessages.filter(msg => msg.type === 'text')
          const imageMessages = newMessages.filter(msg => msg.type === 'image')
          
          // 加载更多时，新消息添加到前面
          const messages = this.data.page === 1 
            ? textMessages 
            : [...textMessages, ...this.data.messages]
            
          const imgMsgs = this.data.page === 1 
            ? imageMessages 
            : [...imageMessages, ...this.data.imageMessages]
          
          this.setData({
            messages,
            imageMessages: imgMsgs,
            hasMoreHistory: hasMore,
            page: this.data.page + 1
          })
        } else {
          wx.showToast({
            title: '加载历史消息失败',
            icon: 'none'
          })
        }
      },
      fail: () => {
        this.setData({ loadingHistory: false })
        wx.showToast({
          title: '网络错误',
          icon: 'none'
        })
      }
    })
  },
  
  // 加载更多历史消息
  loadMoreHistory() {
    this.loadHistoryMessages()
  },
  
  // 监听新消息
  listenNewMessage() {
    app.onMessage(message => {
      // 只处理当前聊天对象的消息
      if (message.fromUserId === this.data.toUserId) {
        message.timeText = this.formatTime(message.time)
        
        // 根据消息类型添加到不同的数组
        if (message.type === 'image') {
          const imageMessages = [...this.data.imageMessages, message]
          this.setData({ imageMessages })
        } else {
          const messages = [...this.data.messages, message]
          this.setData({ messages })
        }
        
        // 滚动到底部
        this.scrollToBottom()
        
        // 标记为已读
        this.markAsRead()
      }
    })
  },
  
  // 格式化时间（时分）
  formatTime(timestamp) {
    const date = new Date(timestamp)
    const hours = date.getHours().toString().padStart(2, '0')
    const minutes = date.getMinutes().toString().padStart(2, '0')
    return `${hours}:${minutes}`
  },
  
  // 格式化日期（年月日）
  formatDate(timestamp) {
    const date = new Date(timestamp)
    const year = date.getFullYear()
    const month = (date.getMonth() + 1).toString().padStart(2, '0')
    const day = date.getDate().toString().padStart(2, '0')
    return `${year}-${month}-${day}`
  },
  
  // 输入框内容变化
  onInputChange(e) {
    this.setData({ inputValue: e.detail.value })
  },
  
  // 发送消息
  sendMessage() {
    const content = this.data.inputValue.trim()
    if (!content) return
    
    // 构造消息对象
    const message = {
      id: Date.now().toString(),
      fromUserId: this.data.currentUserId,
      toUserId: this.data.toUserId,
      content: content,
      type: 'text',
      time: Date.now(),
      timeText: this.formatTime(Date.now())
    }
    
    // 添加到消息列表
    const messages = [...this.data.messages, message]
    this.setData({
      messages,
      inputValue: ''
    })
    
    // 滚动到底部
    this.scrollToBottom()
    
    // 发送到服务器
    app.sendSocketMessage(message)
    
    // 保存到本地数据库
    this.saveMessageToLocal(message)
  },
  
  // 滚动到底部
  scrollToBottom() {
    // 延迟执行，确保DOM已更新
    setTimeout(() => {
      const query = wx.createSelectorQuery().in(this)
      query.select('.message-list').boundingClientRect()
      query.select('.message-container').boundingClientRect()
      query.exec(res => {
        if (res && res[0] && res[1]) {
          this.setData({
            scrollTop: res[0].height - res[1].height
          })
        }
      })
    }, 100)
  },
  
  // 切换表情面板显示
  toggleEmojiPanel() {
    this.setData({ showEmoji: !this.data.showEmoji })
  },
  
  // 选择表情
  selectEmoji(e) {
    const emoji = e.currentTarget.dataset.emoji
    this.setData({
      inputValue: this.data.inputValue + emoji
    })
  },
  
  // 选择图片
  chooseImage() {
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: res => {
        // 上传图片到服务器
        const tempFilePath = res.tempFilePaths[0]
        wx.uploadFile({
          url: 'https://your-server-domain/api/upload/image',
          filePath: tempFilePath,
          name: 'file',
          formData: {
            'userId': this.data.currentUserId
          },
          success: uploadRes => {
            const data = JSON.parse(uploadRes.data)
            if (data.code === 200) {
              // 构造图片消息
              const message = {
                id: Date.now().toString(),
                fromUserId: this.data.currentUserId,
                toUserId: this.data.toUserId,
                content: data.data.url,
                type: 'image',
                time: Date.now(),
                timeText: this.formatTime(Date.now())
              }
              
              // 添加到图片消息列表
              const imageMessages = [...this.data.imageMessages, message]
              this.setData({ imageMessages })
              
              // 滚动到底部
              this.scrollToBottom()
              
              // 发送到服务器
              app.sendSocketMessage(message)
              
              // 保存到本地数据库
              this.saveMessageToLocal(message)
            }
          }
        })
      }
    })
  },
  
  // 保存消息到本地
  saveMessageToLocal(message) {
    wx.getStorage({
      key: `chat_${this.data.currentUserId}_${this.data.toUserId}`,
      success: res => {
        const messages = res.data
        messages.push(message)
        wx.setStorage({ key: `chat_${this.data.currentUserId}_${this.data.toUserId}`, data: messages })
      },
      fail: () => {
        wx.setStorage({ key: `chat_${this.data.currentUserId}_${this.data.toUserId}`, data: [message] })
      }
    })
  },
  
  // 标记消息为已读
  markAsRead() {
    app.sendSocketMessage({
      type: 'read',
      fromUserId: this.data.currentUserId,
      toUserId: this.data.toUserId
    })
  }
})
    