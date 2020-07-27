package com.systop.sbs.util;

/**
 * @Package:
 * @Description： 统一数据格式返回
 * @Author:
 * @Date: 2020/7/27
 * @Modified By:
 */
public class SbsResult {

    private String code;
    private String msg;
    private Integer count;
    private Object data;

    public SbsResult() {
    }

    public SbsResult(String code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static SbsResult success() {
        return new SbsResult("200", "success", 0, null);
    }

    public static SbsResult success(Object data) {
        return new SbsResult("200", "success", 0, data);
    }

    //当需要分页时，传入分页数量
    public static SbsResult success(Integer count, Object data) {
        return new SbsResult("200", "success", count, data);
    }

    public static SbsResult fail(String code, String msg) {
        return new SbsResult(code, msg, null, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
