package com.issc29.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by isaaccohen on 8/2/16.
 */
public class mathUtilsTest {

    @Test
    public void testAdd1Plus1() throws Exception {
        assertEquals(2, mathUtils.sum(1, 1));
    }

    @Test
    public void test1Negative() throws Exception {
        assertEquals(-4, mathUtils.sum(-5, 1));
    }

    @Test
    public void test2Negative() throws Exception {
        assertEquals(-8, mathUtils.sum(-5, -3));
    }
}