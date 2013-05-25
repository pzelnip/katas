'''
Created on May 24, 2013

@author: aparkin
'''
def isAnagram(word, word2):
    w1 = sorted(word)
    w2 = sorted(word2)
    return w1 == w2

anagrams = set()
linecount = 0
with open ("output.txt") as fobj:
    for line in fobj:
        linecount += 1
        if linecount % 1000 == 0:
            print ("lines processed: %s -- unique groups found: %s" % (linecount, len(anagrams)))

        line = line.strip().lower()
        if line.startswith('[') and line.endswith(']'):
            line2 = line[1:-1]
            words = line2.split(", ")

            first_word = words[0]
            for word in words[1:]:
                assert isAnagram(word, first_word), ("%s %s" % (word, first_word))
                    
            keyed = "".join(sorted(first_word))
            assert (not keyed in anagrams), first_word
            anagrams.add(keyed)
        else:
            print ("Invalid line: %s" % line)
        
            
