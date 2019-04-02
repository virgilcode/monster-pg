package jdk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Starstar Sun
 * @date 2019/3/18
 * @Description:
 **/
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/sunvirgil/pg/work/monster-pg/pg-common/src/main/java/jdk/nio/test.txt","rw");
        FileChannel fileChannel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = fileChannel.read(buffer);
        while (read!=-1){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            read = fileChannel.read(buffer);
        }
        aFile.close();
    }
}
