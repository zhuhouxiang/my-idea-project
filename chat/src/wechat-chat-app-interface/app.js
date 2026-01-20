// app.js
App({
  onLaunch() {
    // 初始化WebSocket连接
    this.initWebSocket()
    
    // 检查用户登录状态
    this.checkLoginStatus()
  },
  
  globalData: {
    userInfo: null,
    socketOpen: false,
    socketMsgQueue: [],
    messageCallback: null // 消息回调函数
  },
  
  // 初始化WebSocket连接
  initWebSocket() {
    const that = this
    // 关闭已有的连接
    if (this.globalData.socketTask) {
      this.globalData.socketTask.close()
    }
    
    // 创建新连接
    this.globalData.socketTask = wx.connectSocket({
      url: 'wss://your-server-domain/ws',
      header: {
        'content-type': 'application/json'
      },
      method: 'GET'
    })
    
    // 连接打开
    this.globalData.socketTask.onOpen(() => {
      console.log('WebSocket连接已打开')
      this.globalData.socketOpen = true
      
      // 发送队列中的消息
      for (let msg of this.globalData.socketMsgQueue) {
        this.sendSocketMessage(msg)
      }
      this.globalData.socketMsgQueue = []
    })
    
    // 接收消息
    this.globalData.socketTask.onMessage(res => {
      const message = JSON.parse(res.data)
      console.log('收到消息:', message)
      
      // 如果有回调函数，调用它
      if (this.globalData.messageCallback) {
        this.globalData.messageCallback(message)
      }
    })
    
    // 连接关闭
    this.globalData.socketTask.onClose(() => {
      console.log('WebSocket连接已关闭')
      this.globalData.socketOpen = false
      // 5秒后重连
      setTimeout(() => {
        this.initWebSocket()
      }, 5000)
    })
    
    // 连接错误
    this.globalData.socketTask.onError(err => {
      console.error('WebSocket错误:', err)
      this.globalData.socketOpen = false
    })
  },
  
  // 发送WebSocket消息
  sendSocketMessage(msg) {
    if (this.globalData.socketOpen) {
      this.globalData.socketTask.send({
        data: JSON.stringify(msg)
      })
    } else {
      this.globalData.socketMsgQueue.push(msg)
    }
  },
  
  // 检查登录状态
  checkLoginStatus() {
    wx.getStorage({
      key: 'userInfo',
      success: res => {
        this.globalData.userInfo = res.data
        // 登录后发送用户ID到服务器
        this.sendSocketMessage({
          type: 'login',
          userId: res.data.userId
        })
      },
      fail: () => {
        // 未登录，跳转到登录页
        wx.navigateTo({
          url: '/pages/login/login'
        })
      }
    })
  },
  
  // 设置消息回调
  onMessage(callback) {
    this.globalData.messageCallback = callback
  }
})
    