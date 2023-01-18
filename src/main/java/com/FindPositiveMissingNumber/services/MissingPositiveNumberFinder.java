package com.FindPositiveMissingNumber.services;

import java.util.Arrays;

public class MissingPositiveNumberFinder {
    public static int find(Integer[] array){
        int missingPositive = Integer.MAX_VALUE;

        //Go through the array, find smallest positive number. Assume that's the missing positive
        for (int number : array) {
            if (number >= 0 && number < missingPositive) {
                missingPositive = number;
            }
        }

        while(true){
            if (Arrays.asList(array).contains(missingPositive)){
                missingPositive++; //If array contains missingPositive, increase missingPositive int by 1
            } else {
                break; //missingPositive is not in the array, break loop, that's the missing int
            }
        }

        //Right now the search for missing positive int begins from smallest positive int in the array.
        //So, in the array [1001, 999], the missing int would be 1000
        //If we start the count from 1, this logic can be simplified. However, then in all arrays where 1 is missing,
        //1 will be the missing int.

        return missingPositive;
    }
}
