package com.ming.buffer;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

public class UserBuffer {
    public static final Logger logger = Logger.getLogger("");
    @Test
    public void allocateTest(){

        Buffer buffer = ByteBuffer.allocate(20);


        logger.info("-------------------after allocate---------------------");
        logger.info(String.format("position=%s",buffer.position()));
        logger.info(String.format("limit=%s",buffer.limit()));
        logger.info(String.format("capacity=%s",buffer.capacity()));
    }
}
