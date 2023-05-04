package cn.tedu.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO下网络编程 - 服务器端 - 少量线程处理大量客户端
 */
public class SSCDemo02 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器端启动");
        //1.创建ssc
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2.开启非阻塞模式
        ssc.configureBlocking(false);
        //3.绑定端口
        ServerSocket socket = ssc.socket();
        socket.bind(new InetSocketAddress(9999));

        //4.创建Selector
        Selector selector = Selector.open();
        //5.注册Accept操作
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //6.循环处理
        while(true){
            //--NIO非阻塞模式下，唯一一个可能会产生阻塞的方法
            //--筛选出已经就绪的键，如果没有筛选到，进入阻塞，直到有键就绪为止
            selector.select();
            //7.获取就绪的键
            Set<SelectionKey> set = selector.selectedKeys();
            //8.遍历已经就绪的键
            Iterator<SelectionKey> it = set.iterator();
            while(it.hasNext()){
                //--获取就绪的键
                SelectionKey sk = it.next();
                //--获取就绪的键的操作类型
                if(sk.isAcceptable()){
                    //--当前就绪的键要执行的是接受连接操作
                    //----获取通道
                    ServerSocketChannel selc_ssc = (ServerSocketChannel) sk.channel();
                    //----完成连接
                    SocketChannel sc = null;
                    while(sc==null){
                        sc = selc_ssc.accept();
                    }
                    //----开启sc非阻塞模式
                    sc.configureBlocking(false);
                    //----将sc注册到Selector
                    sc.register(selector, SelectionKey.OP_READ);
                }else if(sk.isConnectable()){
                    //--当前就绪的键要执行的是连接操作
                }else if(sk.isReadable()){
                    //--当前就绪的键要执行的是读操作
                    //----获取当前sk对应的通道
                    SocketChannel selc_sc = (SocketChannel) sk.channel();
                    //----读取数据
                    ByteBuffer buf = ByteBuffer.allocate(10);
                    //----非阻塞模式，无论是否读取到数据都不会阻塞
                    while(buf.hasRemaining()){
                        selc_sc.read(buf);
                    }
                    //----反转缓冲区
                    buf.flip();
                    //----获取并打印数据
                    byte[] array = buf.array();
                    String text = new String(array, "utf-8");
                    System.out.println(text);
                }else if(sk.isWritable()){
                    //--当前就绪的键要执行的是写操作
                }else{
                    throw new RuntimeException("未知的操作类型");
                }
                //8.移除处理完的键
                it.remove();
            }
        }
    }
}
