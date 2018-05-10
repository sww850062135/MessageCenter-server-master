package com.sww.message.entity;

public class JsonResult {

    private String status = null;
    private String msg = null;
    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonResult msg(String msg){
        this.msg = msg;
        return this;
    }
    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}