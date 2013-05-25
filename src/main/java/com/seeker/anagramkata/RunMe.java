package com.seeker.anagramkata;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Sets;

public class RunMe {

    public static List<String> openWordList() {
        InputStream istream = RunMe.class.getResourceAsStream("/wordlist.txt");
        String result = new Scanner(istream).useDelimiter("\\A").next();
        return Arrays.asList(result.split("\\n"));
    }

    public static void main(final String[] args) {
        List<String> lines = openWordList();
        System.out.println("There are " + lines.size() + " words");
        Collection<Set<String>> anagrams = findAnagramsInList(lines);
        System.out.println("Found " + anagrams.size() + " groups of anagrams");
        for (Set<String> group : anagrams) {
            System.out.println(group);
        }
    }

    public static Set<Set<String>> findAnagramsInList(
            final List<String> inputIn) {
        Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();

        for (String s : inputIn) {
            char[] arr = s.toLowerCase().toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            Set<String> group = anagrams.get(key);
            if (group == null) {
                anagrams.put(key, Sets.newHashSet(s));
            } else {
                group.add(s);
            }
        }

        return Sets.newHashSet(anagrams.values());
    }
}
