// pages/login/login.js
const app = getApp()

Page({
  data: {},
  
  onLoad() {},
  
  // 获取用户信息并登录
  onGetUserInfo(e) {
    if (e.detail.userInfo) {
      // 显示加载中
      wx.showLoading({
        title: '登录中...',
        mask: true
      })
      
      // 调用登录接口
      wx.login({
        success: res => {
          // 发送code到服务器换取openid等信息
          wx.request({
            url: 'https://your-server-domain/api/login',
            method: 'POST',
            data: {
              code: res.code,
              userInfo: e.detail.userInfo
            },
            success: loginRes => {
              wx.hideLoading()
              
              if (loginRes.data.code === 200) {
                // 保存用户信息
                app.globalData.userInfo = loginRes.data.data.userInfo
                wx.setStorage({
                  key: 'userInfo',
                  data: loginRes.data.data.userInfo
                })
                
                // 通知服务器用户已登录
                app.sendSocketMessage({
                  type: 'login',
                  userId: loginRes.data.data.userInfo.userId
                })
                
                // 跳转到好友列表页
                wx.switchTab({
                  url: '/pages/contacts/contacts'
                })
              } else {
                wx.showToast({
                  title: '登录失败，请重试',
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
        fail: () => {
          wx.hideLoading()
          wx.showToast({
            title: '登录失败，请重试',
            icon: 'none'
          })
        }
      })
    }
  },
  
  // 显示用户协议
  showAgreement() {
    wx.showModal({
      title: '用户协议',
      content: '请阅读并同意我们的用户协议...',
      showCancel: false
    })
  },
  
  // 显示隐私政策
  showPrivacy() {
    wx.showModal({
      title: '隐私政策',
      content: '请阅读并同意我们的隐私政策...',
      showCancel: false
    })
  }
})
    