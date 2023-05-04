package cn.tedu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO下网络编程 - 客户端 - 少量线程处理大量客户端
 */
public class SCDemo02 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        //1.创建sc
        SocketChannel sc = SocketChannel.open();
        //2.开启非阻塞模式
        sc.configureBlocking(false);
        //3.连接服务器
        //--非阻塞模式，无论是否连接成功都不会阻塞
        //--发起连接
        sc.connect(new InetSocketAddress("localhost", 9999));
        //--完成连接
        while(!sc.finishConnect()) {
        }
        //4.发送数据
        byte [] data = "hello nio!".getBytes("utf-8");
        ByteBuffer buf = ByteBuffer.wrap(data);
        //--非阻塞模式，无论是否发送成功都不会阻塞
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        //5.关闭sc
        sc.close();
    }
}
