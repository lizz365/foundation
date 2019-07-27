package com.lizz.fundation.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
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
        //netty服务装载器
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //主线程池,负责接收创建新线程
        NioEventLoopGroup boos = new NioEventLoopGroup();
        //子线程池,负责读取线程及业务逻辑处理
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
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
                            //子渠道初始化,主要的处理过程
                            new ChannelInitializer<NioSocketChannel>() {
                                @Override
                                protected void initChannel(NioSocketChannel ch) {
                                    //渠道管道处理数据字符集设置
                                    ch.pipeline().addLast(new StringDecoder());
                                    //渠道管道处理
                                    ch.pipeline().addLast(
                                            //显试的处理字符串内容
                                            new SimpleChannelInboundHandler<String>() {
                                                //每个链接都会调用
                                                //netty5.0将重命名为messageReceived
                                                //注意ChannelHandlerContext使用后回被ReferenceCountUtil.release释放
                                                //需要使用ReferenceCountUtil.retain()保持住
                                                @Override
                                                protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                                    System.out.println("line:" + msg);

                                                }
                                            });
                                }
                            })
                    //主线程配置项
                    //ChannelOption.SO_BACKLOG 内核最大线程队列,linux默认128.
                    .option(ChannelOption.SO_BACKLOG, 256)
                    //子线程配置项
                    //开启心跳检测
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //线程监听端口
                    .bind(8000);
        } finally {
            //关闭
//            boos.shutdownGracefully();
//            worker.shutdownGracefully();
        }
    }
}
