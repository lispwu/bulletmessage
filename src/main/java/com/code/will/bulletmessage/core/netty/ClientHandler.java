package com.code.will.bulletmessage.core.netty;

import com.code.will.bulletmessage.core.netty.message.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler<Message> {

    private int roomid = 606118;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("正在登陆房间：{}",roomid);
        String loginMsg = String.format("type@=loginreq/roomid@=%d/",roomid);

        ctx.writeAndFlush(loginMsg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {

        String type = message.getType();
        switch (type){
            case "loginres":
                log.info("login result");
                String joingrop=String.format("type@=joingroup/rid@=%d/gid@=-9999/", roomid);
                channelHandlerContext.writeAndFlush(joingrop);
                break;
            case "qausrespond":
                String hearttext = "type@=mrkl/";
                channelHandlerContext.writeAndFlush(hearttext);
                break;
            case "chatmsg":
                log.debug(new ChatMsg(message).toString());
                break;
            case "dgb":
                log.debug(new DgbMsg(message).toString());
                break;
            case "uenter":
                log.debug(new UenterMsg(message).toString());
                break;
            case "spbc":
                log.debug(new SpbcMsg(message).toString());
                break;
            default:
                log.debug("othertype:{}"+message.getMessage());
                break;
        }


    }


}
