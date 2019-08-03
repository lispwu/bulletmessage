package com.code.will.bulletmessage.core.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * 解码器，根据斗鱼消息协议编写
 *
 * 协议由4个部分组成
 *
 * 1.消息长度 占据4个字节 重复两遍
 * 2.消息头部 占据4个字节  请求 (689 客户端->服务器  690 服务器->客户端) 占两个字节  保密 (一个字节 默认 0x00) 保留 (一个字节 默认0x00)
 * 3.消息内容
 * 4.结束标记  0x00
 *
 */
@Slf4j
public class DYMessageEncoder extends MessageToByteEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, String s, ByteBuf byteBuf) throws Exception {

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

        int messageLength = s.length() + 9;  //为什么+13就报错？
        //写入消息长度两次
        byteBuf.writeBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(messageLength).array());
        byteBuf.writeBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(messageLength).array());
        //写入请求类型
        byteBuf.writeBytes(ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort((short)689).array());
        //写入保留、保密字节
        byteBuf.writeBytes(ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort((short)0).array());

        //写入消息内容
        byteBuf.writeBytes(bytes);
        //写入消息结束

        byteBuf.writeByte(0);
    }
}
