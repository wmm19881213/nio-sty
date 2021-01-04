package com.ming.buffer;

import org.junit.Test;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

/**
 * buffer测试
 */
public class UserBuffer {
    public static final Logger logger = Logger.getLogger("");
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
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<bufferLen;i++) {
            sb.append(i).append(",");
        }
        logger.info(String.format("Read is %s",sb));
        printMsg(buffer);
        //转换成写模式
        buffer.compact();
        buffer.clear();
        int x = 10;
        for(int i=x;i<bufferLen+x;i++){
            buffer.put(i);
        }







    }

    private void printMsg(Buffer buffer) {
        logger.info(String.format("position=%s,limit=%s,capacity=%s", buffer.position(), buffer.limit(), buffer.capacity()));
    }
}
