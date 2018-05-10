package com.sww.message.entity;

public class Template {
    private int tem_id;                 //主键
    private String type;                //模版类型
    private String template_name;       //模版名字
    private String templateid;          //模版ID
    private String autograph;           //短信签名
    private String content;             //短信内容


    public int getTem_id() {
        return tem_id;
    }

    public void setTem_id(int tem_id) {
        this.tem_id = tem_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
