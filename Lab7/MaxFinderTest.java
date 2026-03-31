package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxFinderTest {
    @Test
    void MaxFinderTester(){
        Assertions.assertEquals(12, MaxFinder.findMax(10,12));
    }
    @Test
    void MaxFinderTester2(){
        Assertions.assertEquals(10, MaxFinder.findMax(10,102));
    }

}