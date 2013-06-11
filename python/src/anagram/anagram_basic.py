'''
A basic Python solution to the anagram finding kata.

Created on Jun 11, 2013

@author: aparkin
'''
import sys


def main():
    anagram_buckets = {}
    with open(sys.argv[1]) as fobj:
        for word in fobj:
            word = word.strip()
            key = "".join(sorted(word.lower())) 
            if not anagram_buckets.has_key(key):
                anagram_buckets[key] = []
            anagram_buckets[key].append(word)

    for key, anagram_list in anagram_buckets.iteritems():
        print("%s: %s" % (key, anagram_list))


if __name__ == "__main__":
    main()