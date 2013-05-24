package com.seeker.anagramkata;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class RunMe {

    public static List<String> openWordList() {
        InputStream istream = RunMe.class.getResourceAsStream("/wordlist.txt");
        String result = new Scanner(istream).useDelimiter("\\A").next();
        return Arrays.asList(result.split("\\n"));
    }

    public static void main(final String[] args) {
        List<String> lines = openWordList();
        System.out.println("There are " + lines.size() + " words");
        Set<Set<String>> anagrams = findAnagramsInList(lines);
        System.out.println("Found " + anagrams.size() + " groups of anagrams");
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
    }

    public static Set<Set<String>> findAnagramsInList(final List<String> inputIn) {
        Set<Set<String>> result = new HashSet<Set<String>>();
        Queue<String> inputq = new LinkedList<String>(inputIn);
        
        while (inputq.size() != 0) {
            String word = inputq.remove();
            Set<String> group = new HashSet<String>();
            group.add(word);

            Queue<String> dupe = new LinkedList<String>();
            while (inputq.size() != 0) {
                String possible = inputq.remove();
                if (isAnagram(possible, word)) {
                    group.add(possible);
                } else {
                    dupe.add(possible);
                }
            }
            result.add(group);
            inputq = dupe;
        }
        return result;
    }
    
    public static boolean isAnagram(final String word1, final String word2) {
        if (word1.length() == word2.length()) {
            char[] word1arr = word1.toCharArray();
            Arrays.sort(word1arr);
            char[] word2arr = word2.toCharArray();
            Arrays.sort(word2arr);
            return Arrays.equals(word1arr, word2arr);
        }
        return false;
    }
}
