package cn.tedu.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO下网络编程 - 服务器端
 */
public class SSCDemo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器端..");
        //1.创建ssc
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2.开启非阻塞模式
        ssc.configureBlocking(false);
        //3.通过ssc获取底层的ServerSocket
        ServerSocket socket = ssc.socket();
        //4.监听端口
        socket.bind(new InetSocketAddress(9999));
        //5.等待客户端的连接
        //--非阻塞模式下，无论是否接受到新的客户端都会继续执行
        //--如果接受到了新的连接返回sc代表新连接
        //--如果没有接受到新的连接返回null
        SocketChannel sc = null;
        while(sc == null){
            sc = ssc.accept();//此方法
        }
        //6.获取客户端发送的数据 -- hello nio!
        ByteBuffer buf = ByteBuffer.allocate(10);
        //--此方法没有阻塞，无论是否读取到数据，或者读取到了多少数据都会立即返回
        while(buf.hasRemaining()){
            sc.read(buf);
        }
        //7.处理数据
        byte[] array = buf.array();
        String text = new String(array,"UTF-8");
        System.out.println(text);
        //8.关闭ssc
        sc.close();
        ssc.close();
    }
}
