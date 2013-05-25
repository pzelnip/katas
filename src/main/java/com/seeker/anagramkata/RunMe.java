package com.seeker.anagramkata;

import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

public class RunMe {

    public static List<String> openWordList() {
        InputStream istream = RunMe.class.getResourceAsStream("/wordlist.txt");
        String result = new Scanner(istream).useDelimiter("\\A").next();
        return Arrays.asList(result.split("\\n"));
    }
    
    public static List<String> toLower(final List<String> in) {
        List<String> result = new ArrayList<String>();
        for (String s : in) {
            result.add(s.toLowerCase());
        }
        return result;
    }

    public static void main(final String[] args) {
        List<String> lines = toLower(openWordList());
        System.out.println("There are " + lines.size() + " words");
        Set<Set<String>> anagrams = findAnagramsInList(lines);
        System.out.println("Found " + anagrams.size() + " groups of anagrams");
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
        System.out.println(examineCounts);
        long total = 0;
        for (Entry<String,Integer> entry : examineCounts.entrySet()){
            total += entry.getValue();
        }
        System.out.println("Total examinations: " + total);
    }

    static Map<String,Integer> examineCounts = new HashMap<String,Integer>();
    private static void incrementCount(final String word) {
        if (examineCounts.containsKey(word)) {
            examineCounts.put(word, examineCounts.get(word) + 1);
        } else {
            examineCounts.put(word, 1);
        }
    }
    
    
    public static Set<Set<String>> findAnagramsInList(final List<String> inputIn) {
        Set<Set<String>> result = new HashSet<Set<String>>();
        Queue<String> inputq = new LinkedList<String>(inputIn);
        
        while (inputq.size() != 0) {
            String word = inputq.remove();
            Set<String> group = new HashSet<String>();
            group.add(word);
//incrementCount(word);

            Queue<String> dupe = new LinkedList<String>();
            while (inputq.size() != 0) {
                String possible = inputq.remove();
incrementCount(word);
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
