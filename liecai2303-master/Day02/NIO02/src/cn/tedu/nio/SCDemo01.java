package cn.tedu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO下网络编程 - 客户端
 */
public class SCDemo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端..");
        //1.创建sc
        SocketChannel sc = SocketChannel.open();
        //2.开启非阻塞模式
        sc.configureBlocking(false);
        //3.连接服务器
        //--非阻塞模式下，无论是否连接成功都会立即返回
        //--对服务器发起连接请求
        sc.connect(new InetSocketAddress("localhost",9999));
        //--完成连接，如果没有成功连接上，重复尝试
        while(!sc.finishConnect()){};
        //4.发送数据
        byte[] data = "hello nio!".getBytes("utf-8");
        ByteBuffer buf = ByteBuffer.wrap(data);
        //--write方法没有阻塞，无论是否写出了数据，或者写出了多少数据都会立即返回
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        //5.关闭服务器
        sc.close();
    }
}
