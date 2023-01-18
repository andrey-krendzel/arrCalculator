package com.FindPositiveMissingNumber.controller;


import com.FindPositiveMissingNumber.services.MissingPositiveNumberFinder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
class FindPositiveMissingNumberController {

    @GetMapping("/calculateFromArray/{array}")
    public ResponseEntity<Integer> calculate(@PathVariable("array") Integer[] array) {
       int missingPositive = MissingPositiveNumberFinder.find(array);
       return new ResponseEntity<>(missingPositive, HttpStatus.OK);
    }

    @PostMapping("/calculateFromArray")
    public ResponseEntity<Integer> calculateAlternative(@RequestBody Integer[] array) {
        int missingPositive = MissingPositiveNumberFinder.find(array);
        return new ResponseEntity<>(missingPositive, HttpStatus.OK);
    }

    //Just for testing
    @GetMapping("/")
    public String health() {
        return "Main page";
    }

}


