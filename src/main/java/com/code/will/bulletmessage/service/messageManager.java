package com.code.will.bulletmessage.service;


import com.code.will.bulletmessage.core.DyBulletScreenClient;
import com.code.will.bulletmessage.core.KeepAlive;
import com.code.will.bulletmessage.core.KeepGetMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Slf4j
@Service
public class MessageManager {

    private DyBulletScreenClient dyBulletScreenClient;

    public void startBulletCient(String roomId){

        Assert.hasLength(roomId,"roomId不能为空！");

        if(dyBulletScreenClient == null){

            dyBulletScreenClient = DyBulletScreenClient.getInstance();

            dyBulletScreenClient.init(Integer.valueOf(roomId),-9999);

            //保持弹幕服务器心跳
            KeepAlive keepAlive = new KeepAlive();
            keepAlive.start();

            //获取弹幕服务器发送的所有信息
            KeepGetMsg keepGetMsg = new KeepGetMsg();
            keepGetMsg.start();
        }else {
            log.info("弹幕服务器正在运行！");
        }

    }

    public void stopBulletClient(){

        if(dyBulletScreenClient != null){
            dyBulletScreenClient.stopClient();
            log.info("客户端正在停止......");
        }else {
            log.info("客户端已停止!");
        }
    }


}
