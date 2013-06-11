'''
Created on Jun 10, 2013

@author: aparkin
'''
import sys
import json


class MapReduce:
    '''
    The "fake" MapReduce framework provided by the Coursera data science course,
    with some tweaks added by me.
    '''
    
    def __init__(self):
        self.intermediate = {}
        self.result = []

    def emit_intermediate(self, key, value):
        self.intermediate.setdefault(key, [])
        self.intermediate[key].append(value)

    def emit(self, value):
        self.result.append(value) 

    def execute(self, data, mapper, reducer):
        for line in data:
            try:
                record = json.loads(line)
                mapper(record)
            except ValueError:
                print "Bad line, skipping: '%s'" % line

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        jenc = json.JSONEncoder()
        return jenc.encode(self.result)


'''
Solve the anagram finding problem via map/reduce.  The idea here is to have all
words which are anagrams of each other get mapped to the same reduce bucket. 
'''

mr = MapReduce()

def mapper(record):
    word = record.lower()
    key = "".join(sorted(word))
    mr.emit_intermediate(key, word)


def reducer(key, values):
    mr.emit(values)


def main():
    inputdata = open(sys.argv[1])
    json_result = mr.execute(inputdata, mapper, reducer)
    print json.dumps(json.loads(json_result), sort_keys = True, indent = 2)


if __name__ == "__main__":
    main()