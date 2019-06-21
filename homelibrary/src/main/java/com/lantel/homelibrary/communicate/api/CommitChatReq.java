package com.lantel.homelibrary.communicate.api;

public class CommitChatReq {
    //'学员ID'
    private int sid;
    //消息内容
    private String message;
    //发送类型：0为学生发给机构，1为机构发给学生
    private int send_type;
    //消息类型0为文字1为图片2为语音3为视频4为链接
    private int message_type;
    //发送客户端id,1为教育助手，2为学习管家,10为机构PC端,11为机构微信端,20为学习管家PC端,21为学习管家微信端
    private int app_client_id;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSend_type() {
        return send_type;
    }

    public void setSend_type(int send_type) {
        this.send_type = send_type;
    }

    public int getMessage_type() {
        return message_type;
    }

    public void setMessage_type(int message_type) {
        this.message_type = message_type;
    }

    public int getApp_client_id() {
        return app_client_id;
    }

    public void setApp_client_id(int app_client_id) {
        this.app_client_id = app_client_id;
    }
}
