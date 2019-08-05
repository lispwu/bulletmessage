package com.code.will.bulletmessage.service;


import com.code.will.bulletmessage.core.netty.NettyBulletClient;
import org.springframework.stereotype.Service;

@Service
public class BulletMessageManager {

    private static NettyBulletClient client = new NettyBulletClient();

    public void startClient(int roomid) throws Exception{
        client.start(roomid);
    }

    public void stopClient() throws Exception{
        client.stop();
    }

}
