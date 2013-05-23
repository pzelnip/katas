package com.seeker.anagramkata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;


public class TestRunMe {

    @Test
    public void testTheAnswer() {
        List<String> expected = Arrays.asList("This", "is", "the", "answer", "--", "42");
        List<String> result = RunMe.theAnswer();
        assertEquals(expected, result);
    }

    @Test
    public void findAnagramsInListFindsAllAnagramsWithSmallInput() {
        List<String> input = Arrays.asList("no", "on", "bo");
        Set<Set<String>> expected = new HashSet<Set<String>>();
        expected.add(Sets.newHashSet(Arrays.asList("no", "on")));
        expected.add(Sets.newHashSet(Arrays.asList("bo")));
        
        Set<Set<String>> result = RunMe.findAnagramsInList(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void findAnagramsInListFindsAllAnagramsWithSmallNonOverlappingInput() {
        List<String> input = Arrays.asList("no", "bo");
        Set<Set<String>> expected = new HashSet<Set<String>>();
        expected.add(Sets.newHashSet(Arrays.asList("no")));
        expected.add(Sets.newHashSet(Arrays.asList("bo")));
        
        Set<Set<String>> result = RunMe.findAnagramsInList(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void isAnagramWithAnagramReturnsTrue() {
        String word1 = "rats";
        String word2 = "star";
        
        assertTrue(RunMe.isAnagram(word1, word2));
    }
    
    @Test
    public void isAnagramWithAnagramReturnsFalse() {
        String word1 = "false";
        String word2 = "star";
        
        assertFalse(RunMe.isAnagram(word1, word2));
        
    }
}
