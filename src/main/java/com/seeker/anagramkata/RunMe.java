package com.seeker.anagramkata;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class RunMe {
    public static List<String> theAnswer() {
        return Arrays.asList(StringUtils.split("This is the answer -- 42"));
    }
    
    public static void main(final String [] args) {
        System.out.println(theAnswer());
    }
}

