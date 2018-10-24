// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaName: "",
    priority: "",
    areaId: undefined,
    getAreabyIdUrl: 'http://localhost:8080/demo/area/getAreabyAreaId/',
    createAreaUrl: "http://localhost:8080/demo/area/createArea",
    changeAreaUrl: "http://localhost:8080/demo/area/updateArea"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var _this = this;
    if (options.areaId == undefined) {
      return;
    }
    wx.request({
      url: this.data.getAreabyIdUrl + options.areaId,
      success: function(res) {
        var result = res.data;
        if (result.code == 0) {
          var areaName = result.data.areaName;
          var priority = result.data.priority;
          _this.setData({
            areaId: options.areaId,
            areaName: areaName,
            priority: priority
          })
        } else {
          _this.showCusForm(result.message, '', 2000);
        }

      }
    })
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
  formSubmit: function(e) {
    var formData= e.detail.value;
    var method ="POST";
    var url = this.data.createAreaUrl;
    var _this = this;
    if (this.data.areaId != undefined) {
      url = this.data.changeAreaUrl;
      method="PUT";
      formData.areaId=this.data.areaId;
    }
    wx.request({
      url: url,
      method:method,
      contentType:"application/json",
      data: JSON.stringify(formData),
      success: function(res) {
        var result = res.data;
        if (result.code == 0) {
          _this.showCusForm("操作成功", '', 2000);
          if (_this.data.areaId == undefined) {
            wx.navigateTo({
              url: '../list/list'
            })
          }
        } else {
          _this.showCusForm(result.message, '', 2000);
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
})