package com.ming.buffer;

import org.junit.Test;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

/**
 * buffer读写转换
 */
public class UserBuffer {
    public static final Logger logger = Logger.getLogger("");
    @Test
    public void clearTest(){
        int bufferLen = 5;
        IntBuffer buffer =  IntBuffer.allocate(bufferLen);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<bufferLen;i++){
            buffer.put(i+5);
        }
        buffer.clear();
        for(int i=0;i<bufferLen;i++){
           sb.append(buffer.get()).append(",");
        }


    }

    @Test
    public void allocateTest(){
        int bufferLen = 20;
        IntBuffer buffer = IntBuffer.allocate(bufferLen);
        //写模式
        for(int i=0;i<bufferLen;i++){
            buffer.put(i);
        }
        printMsg(buffer);
        logger.info(String.format("mark=%s",buffer.mark()));
        //转换成读模式
        buffer.flip();
        readBuffer(bufferLen/2, buffer);
        //重新读取
        buffer.rewind();//倒带
        readBuffer(bufferLen/2, buffer);
        //转换成写模式
        buffer.compact();
        buffer.clear();
        buffer.rewind();
        int x = 10;
        StringBuffer sb = new StringBuffer();
        for(int i=x;i<bufferLen+x;i++){
            sb.append(buffer.get()).append(",");
        }
    }

    private void readBuffer(int bufferLen, IntBuffer buffer) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< bufferLen; i++) {
            sb.append(buffer.get()).append(",");
        }
        logger.info(String.format("Read is %s",sb));
        printMsg(buffer);
    }

    private void printMsg(Buffer buffer) {
        logger.info(String.format("position=%s,limit=%s,capacity=%s", buffer.position(), buffer.limit(), buffer.capacity()));
    }
}
