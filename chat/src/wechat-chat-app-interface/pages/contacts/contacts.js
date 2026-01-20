// pages/contacts/contacts.js
const app = getApp()

Page({
  data: {
    frequentlyContacts: [], // 常用联系人
    allContacts: []         // 所有联系人
  },
  
  onLoad() {
    // 加载联系人列表
    this.loadContacts()
    
    // 监听新消息，更新列表显示
    app.onMessage(message => {
      this.updateContactLastMsg(message)
    })
  },
  
  onShow() {
    // 页面显示时刷新联系人列表
    this.loadContacts()
  },
  
  // 加载联系人列表
  loadContacts() {
    wx.showLoading({
      title: '加载中...',
      mask: true
    })
    
    wx.request({
      url: 'https://your-server-domain/api/contacts',
      method: 'GET',
      data: {
        userId: app.globalData.userInfo.userId
      },
      success: res => {
        wx.hideLoading()
        
        if (res.data.code === 200) {
          this.setData({
            frequentlyContacts: res.data.data.frequentlyContacts,
            allContacts: res.data.data.allContacts
          })
        } else {
          wx.showToast({
            title: '加载失败',
            icon: 'none'
          })
        }
      },
      fail: () => {
        wx.hideLoading()
        wx.showToast({
          title: '网络错误',
          icon: 'none'
        })
      }
    })
  },
  
  // 跳转到聊天页面
  goToChat(e) {
    const { userid, username, avatar } = e.currentTarget.dataset
    wx.navigateTo({
      url: `/pages/chat/chat?toUserId=${userid}&toUserName=${username}&toUserAvatar=${avatar}`
    })
  },
  
  // 更新联系人最后一条消息
  updateContactLastMsg(message) {
    // 更新常用联系人
    const frequentlyContacts = this.data.frequentlyContacts.map(contact => {
      if (contact.userId === message.fromUserId) {
        return {
          ...contact,
          lastMsg: message.type === 'image' ? '[图片]' : message.content,
          lastMsgTime: this.formatTime(message.time),
          unreadCount: contact.unreadCount + 1
        }
      }
      return contact
    })
    
    // 更新所有联系人
    const allContacts = this.data.allContacts.map(contact => {
      if (contact.userId === message.fromUserId) {
        return {
          ...contact,
          lastMsg: message.type === 'image' ? '[图片]' : message.content,
          lastMsgTime: this.formatTime(message.time),
          unreadCount: contact.unreadCount + 1
        }
      }
      return contact
    })
    
    this.setData({ frequentlyContacts, allContacts })
  },
  
  // 格式化时间显示
  formatTime(timestamp) {
    const date = new Date(timestamp)
    const hours = date.getHours().toString().padStart(2, '0')
    const minutes = date.getMinutes().toString().padStart(2, '0')
    return `${hours}:${minutes}`
  },
  
  // 显示添加好友菜单
  showAddMenu() {
    wx.showActionSheet({
      itemList: ['添加好友', '创建群聊', '扫一扫'],
      success: res => {
        switch (res.tapIndex) {
          case 0:
            wx.navigateTo({ url: '/pages/add-friend/add-friend' })
            break
          case 1:
            wx.showToast({ title: '创建群聊功能开发中', icon: 'none' })
            break
          case 2:
            wx.scanCode({ success: res => console.log(res) })
            break
        }
      }
    })
  }
})
    