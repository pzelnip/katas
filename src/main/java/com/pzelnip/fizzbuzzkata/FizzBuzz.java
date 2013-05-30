package com.pzelnip.fizzbuzzkata;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzz {

    public static boolean isFizz(final int num) {
        return num % 3 == 0;
    }

    public static boolean isBuzz(final int num) {
        return num % 5 == 0;
    }

    public static boolean isFizzBuzz(final int num) {
        return num % 15 == 0;
    }
    
    public static List<String> fizzBuzz(final int limit) {
        List<String> result = new ArrayList<String>();
        for (int x = 1; x <= limit; x++) {
            if (isFizzBuzz(x)) {
                result.add("fizzbuzz");
            } else if(isFizz(x)) {
                result.add("fizz");
            } else if (isBuzz(x)) {
                result.add("buzz");
            } else {
                result.add(new Integer(x).toString());
            }
        }
        return result;
    }
    
}
