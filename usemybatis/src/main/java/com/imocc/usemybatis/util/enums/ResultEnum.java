package com.imocc.usemybatis.util.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    OPER_SUCCESS(0, "成功"),
    AREA_INSERT_AREANAME_EMPTY(110, "插入区域记录失败,地区名称不能为空!"),
    AREA_INSERT_PRIORITY_EMPTY(111, "插入区域记录失败,权重不能为空!"),
    AREA_INSERT_AREAID_INVALID(112, "插入区域记录失败,未能有效插入!"),
    AREA_UPDATE_ERROR(121, "更新区域信息失败：找不到对应记录!"),
    AREA_UPDATE_AREANAME_EMPTY(122, "更新区域记录失败,地区名称不能为空!"),
    AREA_DELETE(131, "删除区域信息失败：找不到对应记录!"),
    AREA_DELETE_AREAID_EMPTY(132, "删除区域记录失败,areaId不能为空且大于0！");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
