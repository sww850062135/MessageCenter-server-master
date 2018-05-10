package com.sww.message.util;



import java.util.HashMap;

public class ResultMapUtil extends HashMap<String, Object>{
    public ResultMapUtil() {
    }

    public ResultMapUtil success(){
        this.put("code",200);
        return this;
    }
    public ResultMapUtil fail(int code){
        this.put("code",code);
        return this;
    }
    public ResultMapUtil message(String message){
        this.put("message", message);
        return this;
    }

    public ResultMapUtil data(Object object){
        this.put("data", object);
        return this;
    }

}



