package com.pzelnip.katas.fizzbuzzkata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class FizzBuzz {

    private static Map<Integer, String> maps;
    static {
        maps = new HashMap<Integer,String>();
        maps.put(3, "fizz");
        maps.put(5, "buzz");
    }
    
    private static boolean applies(final int number, final int key) {
        return number % key == 0;
    }
    
    public static List<String> fizzBuzz(final int limit) {
        List<String> result = new ArrayList<String>();
        for (int x = 1; x <= limit; x++) {
            String msg = x + ": ";
            for (Entry<Integer, String> entry : maps.entrySet()) {
                if (applies(x, entry.getKey())) {
                    msg += entry.getValue();
                }
            }
            result.add(msg);
        }
        return result;
    }
}