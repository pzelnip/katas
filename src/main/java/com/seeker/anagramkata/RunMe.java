package com.seeker.anagramkata;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class RunMe {
    public static List<String> openWordList() {
        InputStream istream = RunMe.class.getResourceAsStream("/wordlist.txt");
        String result = new Scanner(istream).useDelimiter("\\A").next();
        return Arrays.asList(result.split("\\n"));
    }
    
    public static List<String> theAnswer() {
        return Arrays.asList(StringUtils.split("This is the answer -- 42"));
    }
    
    public static void main(final String [] args) {
        System.out.println(theAnswer());
        
        List<String> lines = openWordList();
//        lines = Arrays.asList("no", "on", "bo", "fred", "refd", "fedr");
        System.out.println("There are " + lines.size() + " words");
        Set<Set<String>> anagrams = findAnagramsInList(lines);
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
    }

    public static Set<Set<String>> findAnagramsInList(final List<String> inputIn) {
        Set<Set<String>> result = new HashSet<Set<String>>();
        
        for (String word : inputIn) {
            boolean groupFound = false;
            for (Set<String> group : result) {
                String groupWord = group.iterator().next();
                if (isAnagram(groupWord, word)) {
                    group.add(word);
                    groupFound = true;
                    break;
                }
            }
            if (!groupFound) {
                result.add(new HashSet<String>(Arrays.asList(word)));
            }
        }

        return result;
    }

    public static boolean isAnagram(final String word1, final String word2) {
        if (word1.length() == word2.length()) {
            char [] word1arr = word1.toCharArray();
            Arrays.sort(word1arr);
            char [] word2arr = word2.toCharArray();
            Arrays.sort(word2arr);
            return Arrays.equals(word1arr, word2arr);
        }
        return false;
    }
}

