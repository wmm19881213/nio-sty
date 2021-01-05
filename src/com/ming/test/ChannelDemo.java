package com.ming.test;

import com.ming.util.IOUtils;
import org.junit.Test;
import sun.nio.ch.FileChannelImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Channel通道主要类型：FileChannel SocketChannel
 *                   ServerSocketChannel DatagramChannel
 *FileChannel:文件通道，阻塞模式
 *
 */
public class ChannelDemo {
    private String sourcePath = "d:/nio-sty-test/source.txt";
    private String desPath = "d:/nio-sty-test/des.txt";

    @Test
    public void testFileChannel(){

        int bufferLen = 1024;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(desPath);

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(bufferLen);

            while(inChannel.read(buffer)!=-1){
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
            //强制刷新到磁盘
            outChannel.force(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            IOUtils.close(fis);
            IOUtils.close(fos);
            IOUtils.close(inChannel);
            IOUtils.close(outChannel);
        }


    }



}
