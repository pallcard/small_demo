package cn.wishhust.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws Exception {
//        FileChannel channel = new FileInputStream("").getChannel();

        // 获取管道
        RandomAccessFile rw = new RandomAccessFile("test.txt", "rw");

        FileChannel rwChannel = rw.getChannel();


        // 准备数据
        String data = "新数据，时间：" +System.currentTimeMillis();
        System.out.println("原数据：\n" + data);

        ByteBuffer buffer = ByteBuffer.allocate(128);
        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();

        // 写入数据
        rwChannel.write(buffer);
        rwChannel.close();
        rw.close();

        // 从新打开管道
        rw = new RandomAccessFile("test.txt", "rw");

        rwChannel = rw.getChannel();

        // 读取刚刚写入的数据
        buffer.clear();
        rwChannel.read(buffer);


        // 打印读取的数据
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("读取到的数据： \n" + new String(bytes));

        rwChannel.close();
        rw.close();


    }
}
