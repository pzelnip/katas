package com.pzelnip.katas.fizzbuzzkata;

import static com.pzelnip.katas.fizzbuzzkata.FizzBuzz.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestFizzBuzz {

    @Test
    public void fizzBuzzTo15ReturnsCorrectResult() {
        List<String> expected = Arrays.asList("1: ", "2: ", "3: fizz", "4: ", 
                "5: buzz", "6: fizz", "7: ", "8: ", "9: fizz", "10: buzz", 
                "11: ", "12: fizz", "13: ", "14: ", "15: fizzbuzz");
        
        List<String> result = fizzBuzz(15);
        
        assertEquals(expected, result);
    }
}