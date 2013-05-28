package com.seeker.anagramkata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * This class contains code that is a solution for Dave Thomas' 6th kata -- the
 * anagram finder.
 * 
 * @see <a
 *      href="http://codekata.pragprog.com/2007/01/kata_six_anagra.html">http://codekata.pragprog.com/2007/01/kata_six_anagra.html</a>
 */
public final class Anagrams {

    private Anagrams() {
    }

    /**
     * Function which maps a word to a form which is unique to all anagrams of
     * that word. That is, if A and B are words which are anagrams of each
     * other, then {@code anagramHash(A) == anagramHash(B)}, and if A and B are
     * not anagrams of each other, then it is guaranteed that
     * {@code anagramHash(A) != anagramHash(B)}
     * 
     * @param word1
     *            the word to process
     * @return a string value that all anagrams of word1 will have if run
     *         through anagramHash
     */
    public static String anagramHash(final String word1) {
        char[] arr = word1.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    /**
     * Given a list of words, partition the list into groups of anagrams such
     * that each word in a group is an anagram of each other. Case is ignored in
     * comparing words, so "Adam", "mada", "aMdA" are all anagrams of each
     * other.
     * 
     * <p>
     * This implementation runs in O(m * n * log(n)) time, where m is the length
     * of {@code words}, and n is the length of each word.
     * </p>
     * 
     * @param words
     *            the list of words to process.
     * @return a set of sets of anagrams
     */
    public static Set<Set<String>> findAnagramsInList(final List<String> words) {
        Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();

        // O(m * n * log(n)), where m is the number of words, and n is the
        // length of word
        for (String s : words) {
            String key = anagramHash(s);

            Set<String> group = anagrams.get(key);
            if (group == null) {
                anagrams.put(key, Sets.newHashSet(s));
            } else {
                group.add(s);
            }
        }

        return Sets.newHashSet(anagrams.values());
    }

    /**
     * Given a collection of anagrams as returned by
     * {@link #findAnagramsInList(List)}, validate that no inconsistencies are
     * present. That is, for each group A within {@code anagrams}, verify that
     * each term is an anagram of each other, and that each group within
     * {@code anagrams} is distinct from each other (that no two terms from
     * separate groups are anagrams of one another).
     * 
     * @param anagrams
     *            a collection of anagrams
     * @return {@code true} if anagrams is valid as per the criteria mentioned
     *         above, {@code false} otherwise
     */
    public static boolean validateAnagramSet(final Set<Set<String>> anagrams) {
        Set<String> seenKeys = new HashSet<String>();
        for (Set<String> group : anagrams) {
            String key = anagramHash(group.iterator().next());

            if (seenKeys.contains(key)) {
                return false;
            }

            for (String word : group) {
                if (!anagramHash(word).equals(key)) {
                    return false;
                }
            }
            seenKeys.add(key);
        }
        return true;
    }

}
