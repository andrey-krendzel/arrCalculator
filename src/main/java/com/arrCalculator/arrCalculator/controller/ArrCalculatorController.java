package com.arrCalculator.arrCalculator.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

@RestController
class ArrCalculatorController {

    @GetMapping("/calculate/{array}")
    public ResponseEntity<Integer> calculate(@PathVariable("array") Integer[] array) {
        int firstPositive = 0;
        int missingPositive = 999;

        //Go through the array, find smallest positive number. Assume that's the missing positive
        for (int number : array) {
            if (number > 0 && number < missingPositive) {
                missingPositive = number;
            }
        }

        System.out.println("Smallest positive: " + missingPositive);


        while(true){
            if (Arrays.asList(array).contains(missingPositive)){
                missingPositive++; //If array contains missingPositive, increase missingPositive int by 1
            } else {
                break; //missingPositive is not in the array, break loop, that's the missing int
            }
        }


        return new ResponseEntity<>(missingPositive, HttpStatus.OK);

    }
}


