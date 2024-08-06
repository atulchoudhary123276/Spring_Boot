package io.javabrains.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test() {
        MathUtils mathUtils=new MathUtils();
        int expected=2;
        int actual=mathUtils.add(1,1);

        assertEquals(expected,actual);
    }
    @Test
    void test1() {
        MathUtils mathUtils=new MathUtils();
        int expected=3;
        int actual=mathUtils.multiply(3,1);

        assertEquals(expected,actual);
    }

    @AfterEach
    void tearDown() {
    }
}