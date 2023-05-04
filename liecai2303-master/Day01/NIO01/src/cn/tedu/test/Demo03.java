package cn.tedu.test;

import java.nio.CharBuffer;

public class Demo03 {
    public static void main(String[] args) {
        //1.创建缓冲区
        CharBuffer buf = CharBuffer.allocate(5);
        //2.写入数据
        buf.put('a');
        buf.put('b');
        buf.put('c');
        //3.翻转缓冲区
        buf.flip();
        //4.读取数据
        //while(buf.remaining()>0){
        while(buf.hasRemaining()){
            char c = buf.get();
            System.out.println(c);
        }

    }
}
