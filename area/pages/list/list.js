// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    getAreasUrl: 'http://localhost:8080/demo/area/getAreas',
    delAreaUrl: "http://localhost:8080/demo/area/deleteArea/"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    var _this = this;

    wx.request({
      url: _this.data.getAreasUrl,
      data: {},
      success(res) {
        if (res.data.code == 0) {
          _this.setData({
            list: res.data.data
          })
        } else {
          var toastText = res.data.message;
          _this.showCusForm(toastText, '', 2000);
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },

  delArea: function(e) {
    var dataset = e.target.dataset;
    var areaName = dataset.areaname;
    var areaid = dataset.areaid;
    var index = dataset.index;
    var msg = "删除成功";
    var _this = this;
    wx.showModal({
      title: '提示',
      content: '您确定要删除[' + areaName + ']吗?',
      success(res) {
        if (res.confirm) {
          wx.request({
            url: _this.data.delAreaUrl + areaid,
            method: 'DELETE',
            data: {},
            success(res) {
              if (res.data.code == 0) {
                _this.showCusForm(msg, 'success', 2000);
                _this.data.list.splice(index, 1);
                _this.setData({
                  list: _this.data.list
                });
              } else {
                _this.showCusForm(res.data.message, '', 2000);
              }
            }
          })
        }
      }
    })
  },

  /**
   * 弹出信息提示
   */
  showCusForm: function(msg, icon, time) {
    wx.showToast({
      title: msg,
      icon: icon,
      duration: time
    })
  },
  /**
   * 跳转到添加区域界面
   */
  addArea:function(){
    wx.navigateTo({
      url: '../operation/operation'
    })
  }
})