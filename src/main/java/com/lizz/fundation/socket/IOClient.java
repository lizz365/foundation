package com.lizz.fundation.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * IOClient
 * 客户端连接上服务端8000端口之后，每隔2秒，我们向服务端写一个带有时间戳的 "hello world"。
 * @author lizz365
 * @date 19/7/2
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

        System.out.println("1111111111111");
    }
}
