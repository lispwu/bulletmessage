package com.code.will.bulletmessage.core.netty;

import com.code.will.bulletmessage.core.netty.message.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler<Message> {

    private String roomId;

    public ClientHandler(String roomid) {
        this.roomId = roomid;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("正在登陆房间：{}",roomId);
        String loginMsg = String.format("type@=loginreq/roomid@=%s/",roomId);

//        String loginMsg2 = String.format("type@=loginreq/roomid@=%d/",74751);

        ctx.writeAndFlush(loginMsg);
//        ctx.writeAndFlush(loginMsg2);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {

        String type = message.getType();
        switch (type){
            case "loginres":
                log.info("login result");
                String joingrop=String.format("type@=joingroup/rid@=%s/gid@=-9999/", roomId);
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
