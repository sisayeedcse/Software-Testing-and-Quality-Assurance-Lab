package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EvenCheckerTest {
    @Test
    void EvenCheckerTester(){
        Assertions.assertEquals(true, EvenChecker.isEven(10));
    }
    @Test
    void EvenCheckerTester2(){
        Assertions.assertEquals(false, EvenChecker.isEven(11));
    }

}