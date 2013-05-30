package com.pzelnip.katas.fizzbuzzkata;

public class RunMe {

    public static void main(final String [] args) {
        for (String msg : FizzBuzz.fizzBuzz(100)) {
            System.out.println(msg);
        }
    }
}

