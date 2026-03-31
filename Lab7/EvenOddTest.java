package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EvenOddTest {

    @Test
    void EvenOddTester(){
        Assertions.assertEquals("Positive", EvenOdd.evenOdd.PosNeg(10));
    }
    @Test
    void EvenOddTester2(){
        Assertions.assertEquals("Positive", EvenOdd.evenOdd.PosNeg(-10));
    }
    @Test
    void EvenOddTester3(){
        Assertions.assertEquals("Positive", EvenOdd.evenOdd.PosNeg(11.50));
    }


}