package com.seeker.anagramkata;

import static com.seeker.anagramkata.Anagrams.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RunMe {

    static List<String> openWordList() {
        InputStream istream = RunMe.class.getResourceAsStream("/wordlist.txt");
        String result = new Scanner(istream).useDelimiter("\\A").next();
        return Arrays.asList(result.split("\\n"));
    }

    static void spitStats(final List<String> words) {
        long total = 0;
        int min = Integer.MAX_VALUE;
        String minword = "";
        int max = 0;
        String maxword = "";
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for (String word : words) {
            int wordlen = word.length();

            Integer count = frequencies.get(wordlen);
            if (count == null) {
                frequencies.put(wordlen, 1);
            } else {
                frequencies.put(wordlen, count + 1);
            }
            total += wordlen;
            if (wordlen < min) {
                min = wordlen;
                minword = word;
            }
            if (wordlen > max) {
                max = wordlen;
                maxword = word;
            }
        }

        double avglen = (total * 1.0) / words.size();
        System.out.println("There are " + words.size() + " words");
        System.out.println("Average length: " + avglen);
        System.out.println(String.format("Max length: %s (%s)", maxword, max));
        System.out.println(String.format("Min length: %s (%s)", minword, min));
        System.out.println("Histogram:");
        for (int x = min; x <= max; x++) {
            Integer count = frequencies.get(x);
            System.out.print(String.format("%2d: ", x));
            if (count != null) {
                for (int y = 0; y < count / 80; y++) {
                    System.out.print("X");
                }
                if (count / 80 < 1 && count != 0) {
                    System.out.print("X");
                }
            }
            System.out.println();
        }

        System.out.print("Histogram raw counts: ");
        for (int x = min; x <= max; x++) {
            Integer count = frequencies.get(x);
            System.out.print(String
                    .format("%s ", (count == null ? "0" : count)));
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        List<String> lines = openWordList();
        spitStats(lines);
        Collection<Set<String>> anagrams = findAnagramsInList(lines);
        System.out.println("Found " + anagrams.size() + " groups of anagrams");
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
    }
}
