package com.ming.buffer;

import org.junit.Test;

import java.nio.IntBuffer;
import java.util.logging.Logger;

public class UserBuffer {
    public static final Logger logger = Logger.getLogger("");
    @Test
    public void allocateTest(){
        IntBuffer intBuffer = IntBuffer.allocate(20);


        logger.info("-------------------after allocate---------------------");
        logger.info(String.format("position=%s",intBuffer.position()));
        logger.info(String.format("limit=%s",intBuffer.limit()));
        logger.info(String.format("capacity=%s",intBuffer.capacity()));
    }
}
