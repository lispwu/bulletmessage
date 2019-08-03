package com.code.will.bulletmessage.core.netty.message;

import java.util.HashMap;
import java.util.Map;

public class Message {

    protected String message;

    protected String type;

    protected Map<String,String> msgDetail;

    public Message(String message){
        this(message,"/","@=");
    }

    public Message(Message message) {
        this.message = message.message;
        this.type = message.type;
        this.msgDetail = new HashMap<>(message.msgDetail);
    }

    public Message(String message,String split1,String split2){
        this.message = message;
        msgDetail = parser(message,split1,split2);
        type = msgDetail.get("type");
    }

    public static Map<String,String> parser(String message,String split1,String split2){
        Map<String,String> map = new HashMap<>();

        String[] splitMessage = message.split(split1);
        for(int i = 0;i < splitMessage.length;i++){
            String[] splitDetail = splitMessage[i].split(split2);
            if(splitDetail.length == 2){
                map.put(splitDetail[0],splitDetail[1]);
            }
        }

        return map;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(Map<String, String> msgDetail) {
        this.msgDetail = msgDetail;
    }
}
