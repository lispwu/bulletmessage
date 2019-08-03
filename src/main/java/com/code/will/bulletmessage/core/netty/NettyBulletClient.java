package com.code.will.bulletmessage.core.netty;

import com.code.will.bulletmessage.core.netty.codec.DYMessageDecoder;
import com.code.will.bulletmessage.core.netty.codec.DYMessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class NettyBulletClient {

    private static final int PORT = 8601;

    private static final String HOST = "openbarrage.douyutv.com";


    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .remoteAddress(new InetSocketAddress(HOST, PORT))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new DYMessageDecoder());
                            p.addLast(new DYMessageEncoder());
                            p.addLast(new ClientHandler());

                        }
                    });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws Exception{
        new NettyBulletClient().start();
    }
}
