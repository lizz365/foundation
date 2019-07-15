package com.lizz.fundation.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * NettyServer
 *
 * @author lizz365
 * @date 19/7/2
 */
public class NettyServer {
    public static void main(String[] args) {
        //netty装载器
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //主线程池,负责接收创建新线程
        NioEventLoopGroup boos = new NioEventLoopGroup();
        //子线程池,负责读取线程及业务逻辑处理
        NioEventLoopGroup worker = new NioEventLoopGroup();
        //装载并启动netty服务
        serverBootstrap
                //装载主从线程池
                .group(boos, worker)
                //通道类型,NioServerSocketChannel和NioSocketChannel,此处为服务器通道
                .channel(NioServerSocketChannel.class)
                //主线程处理器
                .handler(new LoggingHandler())
                //子线程处理器
                .childHandler(
                        //子渠道初始化
                        new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel ch) {
                                ch.pipeline().addLast(new StringDecoder());
                                ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                        System.out.println(msg);
                                    }
                                });
                            }
                        })
                .bind(8000);
    }
}
