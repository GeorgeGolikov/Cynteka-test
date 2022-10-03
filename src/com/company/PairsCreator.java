package com.company;

import java.util.ArrayList;
import java.util.List;

public class PairsCreator {
    private final String PAIR_NOT_EXISTS = ":?";

    private final List<String> firstList;
    private final List<String> secondList;
    private final List<String> similarPairsList;

    private final int firstListSize;
    private final int secondListSize;

    private final boolean[] secondListItemsPaired;

    private final StringBuilder sb;

    private final DefinitionOfSimilar similar;

    public PairsCreator(List<String> firstList, List<String> secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
        firstListSize = firstList.size();
        secondListSize = secondList.size();
        similarPairsList = new ArrayList<>(firstListSize + secondListSize);
        secondListItemsPaired = new boolean[secondListSize];
        sb = new StringBuilder();
        similar = new DefinitionOfSimilar();
    }

    public List<String> createSimilarPairs() {
        findPairsForFirstList();
        processUnpairedFromSecondList();
        return similarPairsList;
    }

    private void findPairsForFirstList() {
        for (var item : firstList) {
            appendNotPairedSymbolToItem(item);
            searchForPairInSecondList(item);
            addItem();
        }
    }

    private void appendNotPairedSymbolToItem(String item) {
        sb.append(item).append(PAIR_NOT_EXISTS);
    }

    private void searchForPairInSecondList(String item) {
        for (int i = 0; i < secondListSize; ++i) {
            if (itemPaired(i)) continue;
            String another = secondList.get(i);
            if (similar.isSimilar(item, another)) {
                appendPairAndMarkPaired(another, i);
                break;
            }
        }
    }

    private void addItem() {
        similarPairsList.add(sb.toString());
        sb.setLength(0);
    }

    private void appendPairAndMarkPaired(String another, int index) {
        int length = sb.length();
        sb.replace(length - 1, length, another);
        secondListItemsPaired[index] = true;
    }

    private void processUnpairedFromSecondList() {
        for (int i = 0; i < secondListSize; ++i) {
            addItemToListIfUnpaired(i);
        }
    }

    private void addItemToListIfUnpaired(int index) {
        if (itemUnpaired(index)) {
            appendNotPairedSymbolToItem(secondList.get(index));
            addItem();
        }
    }

    private boolean itemUnpaired(int index) {
        return !secondListItemsPaired[index];
    }

    private boolean itemPaired(int index) {
        return secondListItemsPaired[index];
    }
}
