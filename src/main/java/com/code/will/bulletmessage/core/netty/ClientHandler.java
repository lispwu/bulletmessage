package com.code.will.bulletmessage.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        //登入弹幕服务器



        //进入弹幕池



        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }
}
