package com.code.will.bulletmessage.core.netty.codec;

import com.code.will.bulletmessage.core.netty.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DYMessageDecoder extends ByteToMessageDecoder {

    //服务端发到客户端的标识
    public static final byte[] SERVER_FLAG = new byte[]{(byte) 0xb2, 0x02, 0x00, 0x00};

    private byte[] messageCache = new byte[4096];

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {


        //根据斗鱼消息协议,除去消息内容的长度为13，如果消息内容为空，则直接返回
        if(byteBuf.readableBytes() < 12){
            return;
        }

        //先获取消息长度
        byte[] msgLength1 = new byte[4];
        byteBuf.getBytes(byteBuf.readerIndex(),msgLength1);

        byte[] msgLength2 = new byte[4];
        byteBuf.getBytes(byteBuf.readerIndex() + 4,msgLength2);

        int msgSize1 = ByteBuffer.wrap(msgLength1).order(ByteOrder.LITTLE_ENDIAN).getInt();
        int msgSize2 = ByteBuffer.wrap(msgLength2).order(ByteOrder.LITTLE_ENDIAN).getInt();

        if(msgSize1 != msgSize2){
            log.error("消息长度不相等，消息体解析错误");
            return;
        }

        //获取消息类型
        byte[] flag = new byte[4];
        byteBuf.getBytes(byteBuf.readerIndex() + 8,flag);
        if(!Arrays.equals(SERVER_FLAG,flag)){
            log.error("消息类型错误！");
            return;
        }

        //获取消息内容
        if(msgSize1 > 0){
            int currentSize = msgSize1 + 4;
            if (byteBuf.readableBytes() >= currentSize) {
                if(messageCache.length < currentSize){
                    messageCache = new byte[currentSize];
                }

                byteBuf.readBytes(messageCache,0,currentSize);

                String message = new String(messageCache,12,currentSize - 13, StandardCharsets.UTF_8);

                list.add(new Message(message));
            }
        }

    }

}
