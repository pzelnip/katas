package com.seeker.anagramkata;

import static com.seeker.anagramkata.RunMe.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;


public class TestRunMe {
    
    @Test
    public void findAnagramsInListFindsAllAnagramsWithSmallInput() {
        List<String> input = Arrays.asList("no", "on", "bo");
        Collection<Set<String>> expected = new HashSet<Set<String>>();
        expected.add(Sets.newHashSet(Arrays.asList("no", "on")));
        expected.add(Sets.newHashSet(Arrays.asList("bo")));
        
        Collection<Set<String>> result = RunMe.findAnagramsInList(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void findAnagramsInListFindsAllAnagramsWithSmallNonOverlappingInput() {
        List<String> input = Arrays.asList("no", "bo");
        Collection<Set<String>> expected = new HashSet<Set<String>>();
        expected.add(Sets.newHashSet(Arrays.asList("no")));
        expected.add(Sets.newHashSet(Arrays.asList("bo")));
        
        Collection<Set<String>> result = RunMe.findAnagramsInList(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void validateAnagramSetReturnsTrueWithValidSet() {
        Set<Set<String>> validSet = new HashSet<Set<String>>();
        validSet.add(Sets.newHashSet(Arrays.asList("boo", "oob")));
        validSet.add(Sets.newHashSet(Arrays.asList("frank")));
        
        boolean result = RunMe.validateAnagramSet(validSet);
        
        assertTrue(result);
    }

    @Test
    public void validateAnagramSetReturnsFalseWithGroupWhichContainsTermWhichIsNotAnagramOfOthers() {
        Set<Set<String>> validSet = new HashSet<Set<String>>();
        validSet.add(Sets.newHashSet(Arrays.asList("boo", "oob", "bob")));
        validSet.add(Sets.newHashSet(Arrays.asList("frank")));
        
        boolean result = RunMe.validateAnagramSet(validSet);
        
        assertFalse(result);
    }

    @Test
    public void validateAnagramSetReturnsFalseWithOverlappingAnagramGroups() {
        Set<Set<String>> validSet = new HashSet<Set<String>>();
        validSet.add(Sets.newHashSet(Arrays.asList("boo", "oob")));
        validSet.add(Sets.newHashSet(Arrays.asList("frank")));
        validSet.add(Sets.newHashSet(Arrays.asList("boo", "obo")));
        
        boolean result = RunMe.validateAnagramSet(validSet);
        
        assertFalse(result);
    }

    @Test
    public void anagramHashReturnsSameResultForTwoAnagrams() {
        String word1 = "adam";
        String word2 = "mada";
        
        assertEquals(RunMe.anagramHash(word1), RunMe.anagramHash(word2));
    }

    @Test
    public void anagramHashReturnsDifferentResultForTwoWordsThatAreNotAnagamButSameLength() {
        String word1 = "adam";
        String word2 = "mood";
        
        assertNotEquals(RunMe.anagramHash(word1), RunMe.anagramHash(word2));
    }

    @Test
    public void anagramHashReturnsDifferentResultForTwoWordsThatAreNotAnagamAndDifferentLength() {
        String word1 = "moody";
        String word2 = "mood";
        
        assertNotEquals(RunMe.anagramHash(word1), RunMe.anagramHash(word2));
    }
    
    @Test
    public void findAnagramsInListIsValidOnOpenWordListInput() {
        assertTrue(validateAnagramSet(findAnagramsInList(openWordList())));
    }
}
