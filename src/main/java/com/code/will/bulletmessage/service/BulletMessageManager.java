package com.code.will.bulletmessage.service;


import com.code.will.bulletmessage.core.netty.NettyBulletClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class BulletMessageManager {

    private static Map<String,NettyBulletClient> clientHolder;

    static {
        clientHolder = new ConcurrentHashMap<>();
    }

    public void startClient(int roomid) throws Exception{

        if(clientHolder.get(String.valueOf(roomid)) == null){
            NettyBulletClient client = new NettyBulletClient();
            client.start(roomid);
            clientHolder.put(String.valueOf(roomid),client);
            log.info("保存房间信息成功，已有{}个房间正在连接",clientHolder.size());
        }else {
            log.info("该房间已连接！");
        }

    }

    public String listAllRoom() throws Exception{
        if(clientHolder.isEmpty()){
            return "没有正在连接的房间！";
        }

        StringBuilder roomIds = new StringBuilder();
        roomIds.append("正在连接房间：");
        for(String roomId:clientHolder.keySet()){
            log.info("正在连接房间：{}",roomId);
            roomIds.append(roomId).append(" ");
        }
        return roomIds.toString();
    }

    public void stopSpecificRoom(String roomId) throws Exception{
        NettyBulletClient client = clientHolder.get(roomId);

        if(client != null){
            client.stop();
            clientHolder.remove(roomId);
        }else {
            log.info("该房间已关闭!");
        }
    }

    public String stopAllRoom() throws Exception{
        if(clientHolder.isEmpty()){
            return "没有正在连接的房间";
        }

        for(Map.Entry<String,NettyBulletClient> entry:clientHolder.entrySet()){
            log.info("正在关闭房间: {}",entry.getKey());
            NettyBulletClient client = entry.getValue();
            client.stop();
        }
        clientHolder.clear();

        return "已关闭所有房间!";
    }

}
