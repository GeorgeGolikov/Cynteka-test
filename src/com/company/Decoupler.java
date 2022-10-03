package com.company;

import java.util.List;

public class Decoupler {
    List<String> inputList;

    public Decoupler(List<String> inputList) {
        this.inputList = inputList;
    }

    public PairsCreator decoupleInputList() throws RuntimeException {
        try {
            int numOfLinesInFirstList = Integer.parseInt(inputList.get(0));
            List<String> firstList = inputList.subList(1, numOfLinesInFirstList + 1);
            List<String> secondList = inputList.subList(numOfLinesInFirstList + 2, inputList.size());
            return new PairsCreator(firstList, secondList);
        } catch (RuntimeException cause) {
            throw new RuntimeException("Invalid input list", cause);
        }
    }
}
