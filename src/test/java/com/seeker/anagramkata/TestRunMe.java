package com.seeker.anagramkata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;


public class TestRunMe {
    
    @Test
    public void partitionByLengthTypicalCase() {
        List<String> input = Arrays.asList("adam", "jo", "julie", "fred");
        Map<Integer, List<String>> expected = new HashMap<Integer,List<String>>();
        expected.put(4, Arrays.asList("adam", "fred"));
        expected.put(2, Arrays.asList("jo"));
        expected.put(5, Arrays.asList("julie"));
        
        Map<Integer, List<String>> result = RunMe.partitionByLength(input);
        
        assertEquals(expected, result);
    }

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
    
}
