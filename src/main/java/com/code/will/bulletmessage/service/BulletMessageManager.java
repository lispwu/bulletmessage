package com.code.will.bulletmessage.service;


import com.code.will.bulletmessage.core.netty.NettyBulletClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class BulletMessageManager {

    @Autowired
    TaskExecutor taskExecutor;

    private static Map<String,String> roomList = new ConcurrentHashMap<>();


    public void startClient(String roomId) throws Exception{

        if(roomList.get(roomId) == null){

            taskExecutor.execute(new NettyBulletClient(roomId));

            roomList.put(roomId,"已连接");
            log.info("保存房间信息成功，已有{}个房间正在连接",roomList.size());
        }else {
            log.info("该房间已连接！");
        }

    }

    public String listAllRoom() throws Exception{
        if(roomList.isEmpty()){
            return "没有正在连接的房间！";
        }

        StringBuilder roomIds = new StringBuilder();
        roomIds.append("正在连接房间：");
        for(String roomId:roomList.keySet()){
            log.info("正在连接房间：{}",roomId);
            roomIds.append(roomId).append(" ");
        }
        return roomIds.toString();
    }

    public void stopSpecificRoom(String roomId) throws Exception{

    }

    public String stopAllRoom() throws Exception{

    }

}
