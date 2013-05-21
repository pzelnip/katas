package com.seeker.anagramkata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestRunMe {

    @Test
    public void testTheAnswer() {
        List<String> expected = Arrays.asList("This", "is", "the", "answer", "--", "42");
        List<String> result = RunMe.theAnswer();
        assertEquals(expected, result);
    }

}
