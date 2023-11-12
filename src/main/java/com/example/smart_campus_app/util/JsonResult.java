package com.example.smart_campus_app.util;
/**
*@Description
*
*@Expositor 余.
*@Date Created in 2023/11/7 17:04
**/
public class JsonResult {



    //调用返回格式，返回成功的结果
    public static JsonResult sucess(Object result){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("访问成功");
        jsonResult.setObj(result);
        return jsonResult;
    }
//    新建这个类  用来规范前台的信息传递，，，相当于是模板
private Integer code;
private String msg;
    private Object obj;



    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {

        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "JsonResult{" +


                ", code=" + code +
                ", msg='" + msg + '\'' +
                "obj=" + obj +
                '}';
    }
}
