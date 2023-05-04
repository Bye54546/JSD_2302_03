package cn.tedu.test;

import java.nio.CharBuffer;

public class Demo02 {
    public static void main(String[] args) {
        //1.创建Buffer
        CharBuffer buf = CharBuffer.allocate(5);
        //2.写入数据
        buf.put('a');
        buf.put('b');
        buf.put('c');
        //buf.put('d');
        //buf.put('e');
        //buf.put('f');

        //3.切换读模式
        buf.flip();

        //4.读取数据
        char c1 = buf.get();
        System.out.println(c1);
        char c2 = buf.get();
        System.out.println(c2);
        char c3 = buf.get();
        System.out.println(c3);
        //char c4 = buf.get();
        //System.out.println(c4);

        //5.清空缓冲区
        buf.clear();

        //6.写入数据
        buf.put('x');
        buf.put('y');
        //7.切换读模式
        buf.flip();
        //8.读取数据
        char c4 = buf.get();
        System.out.println(c4);
        char c5 = buf.get();
        System.out.println(c5);
        char c6 = buf.get();
        System.out.println(c6);
        //打印
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }
}
