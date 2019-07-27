package com.lizz.fundation.socket.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * NettyClient
 *
 * @author lizz365
 * @date 19/7/2
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //netty客户端装载器
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            //设置循环线程组
            bootstrap.group(group)
                    //渠道类型
                    .channel(NioSocketChannel.class)
                    //主线程处理器
                    .handler(
                            new ChannelInitializer<Channel>() {
                                @Override
                                protected void initChannel(Channel ch) {
                                    ch.pipeline().addLast(new StringEncoder());
                                }
                            });

            Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

            while (true) {
                channel.writeAndFlush(new Date() + ": hello world!");
                channel.write("111111");
                channel.write("222");
                channel.flush();
                Thread.sleep(2000);
            }
        }finally {
            //关闭
            group.shutdownGracefully();
        }
    }
}
