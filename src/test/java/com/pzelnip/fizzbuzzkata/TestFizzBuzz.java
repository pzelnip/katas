package com.pzelnip.fizzbuzzkata;

import static com.pzelnip.fizzbuzzkata.FizzBuzz.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestFizzBuzz {

    @Test
    public void testIsFizzWithNumberDivisibleBy3ReturnsTrue() {
        assertTrue(isFizz(9));
    }

    @Test
    public void testIsFizzWithNumberNotDivisibleBy3ReturnsFalse() {
        assertFalse(isFizz(11));
    }
    
    @Test
    public void testIsBuzzWithNumberDivisibleBy5ReturnsTrue() {
        assertTrue(isBuzz(10));
    }

    @Test
    public void testIsBuzzWithNumberNotDivisibleBy5ReturnsFalse() {
        assertFalse(isBuzz(11));
    }

    @Test
    public void isFizzBuzzWithNumberDivisibleBy15ReturnsTrue() {
        assertTrue(isFizzBuzz(30));
    }

    @Test
    public void isFizzBuzzWithNumberNotDivisibleBy15ReturnsTrue() {
        assertFalse(isFizzBuzz(22));
    }
    
    @Test
    public void fizzBuzzTo15ReturnsCorrectResult() {
        List<String> expected = Arrays.asList("1", "2", "fizz", "4", "buzz",
                "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14",
                "fizzbuzz");
        
        List<String> result = fizzBuzz(15);
        
        assertEquals(expected, result);
    }
}
