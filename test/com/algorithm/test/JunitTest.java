package com.algorithm.test;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest {
    @BeforeClass
    public static void makeInstance()throws Exception {
        System.out.println("Test Start!");
    }

    @Test
    public void test1() throws Exception {

    }
}