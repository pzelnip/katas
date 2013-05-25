package com.seeker.anagramkata;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.inject.internal.util.Lists;

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
        Collection<Set<String>> anagrams = findAnagramsInList(lines);
        System.out.println("Found " + anagrams.size() + " groups of anagrams");
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
    }

    public static Collection<Set<String>> findAnagramsInList(
            final List<String> inputIn) {
        Set<Set<String>> result = new HashSet<Set<String>>();
        Map<Integer, List<String>> parts = partitionByLength(inputIn);
        for (List<String> words : parts.values()) {
            result.addAll(findAnagramsInListHelper(words));
        }
        return result;
    }

    private static Collection<Set<String>> findAnagramsInListHelper(
            final List<String> inputIn) {
        Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();

        for (String s : inputIn) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            Set<String> group = anagrams.get(key);
            if (group == null) {
                anagrams.put(key, Sets.newHashSet(s));
            } else {
                group.add(s);
            }
        }

        return anagrams.values();
    }

    public static Map<Integer, List<String>> partitionByLength(
            final List<String> input) {
        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
        for (String s : input) {
            List<String> value = result.get(s.length());
            if (value == null) {
                result.put(s.length(), Lists.newArrayList(s));
            } else {
                value.add(s);
            }
        }
        return result;
    }
}
