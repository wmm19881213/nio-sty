package com.ming.buffer;

import org.junit.Test;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

public class UserBuffer {
    public static final Logger logger = Logger.getLogger("");
    @Test
    public void allocateTest(){
        int bufferLen = 20;
        IntBuffer buffer = IntBuffer.allocate(bufferLen);
        for(int i=0;i<bufferLen;i++){
            buffer.put(i);
        }
        printMsg(buffer);
        buffer.flip();
        printMsg(buffer);
    }

    private void printMsg(Buffer buffer) {
        logger.info(String.format("position=%s,limit=%s,capacity=%s", buffer.position(), buffer.limit(), buffer.capacity()));
    }
}
