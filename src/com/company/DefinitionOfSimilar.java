package com.company;

import java.util.Locale;

public class DefinitionOfSimilar {
    private final NonLexicalSimilaritiesStorage storage = new NonLexicalSimilaritiesStorage();

    public boolean isSimilar(String item, String another) {
        item = item.toLowerCase(Locale.ROOT);
        another = another.toLowerCase(Locale.ROOT);

        if (canBeFoundInStorage(item, another)) return true;
        if (equalsOrContains(item, another)) return true;
        return canBeSplittedIntoWordsContainingSimilarOnes(item, another);
    }

    private boolean canBeFoundInStorage(String item, String another) {
        return storage.contains(item, another);
    }

    private boolean equalsOrContains(String item, String another) {
        return item.equals(another) ||
               item.contains(another) ||
               another.contains(item);
    }

    private boolean canBeSplittedIntoWordsContainingSimilarOnes(String item, String another) {
        String[] stringsItem = item.split("\\s");
        String[] stringsAnother = another.split("\\s");
        if (oneOfStringsContainsMoreThanOneWord(stringsItem, stringsAnother)) {
            return stringsHaveAtLeastOneSimilarWord(stringsItem, stringsAnother);
        }
        return false;
    }

    private boolean oneOfStringsContainsMoreThanOneWord(String[] stringsItem, String[] stringsAnother) {
        return stringsItem.length > 1 || stringsAnother.length > 1;
    }

    private boolean stringsHaveAtLeastOneSimilarWord(String[] stringsItem, String[] stringsAnother) {
        return iterateFirstAndSecondArrays(stringsItem, stringsAnother);
    }

    private boolean iterateFirstAndSecondArrays(String[] stringsItem, String[] stringsAnother) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringsItem.length; ++i) {
            String strFromItem = stringsItem[i];
            if (isPrepositionBeforeWord(stringsItem, i)) {
                strFromItem = concatenatePrepositionWithWord(sb, stringsItem, i);
                ++i;
            }

            if (iteratedSecondArrayAndFoundSimilar(sb, stringsAnother, strFromItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean iteratedSecondArrayAndFoundSimilar(StringBuilder sb, String[] stringsAnother, String key) {
        for (int j = 0; j < stringsAnother.length; ++j) {
            String strFromAnother = stringsAnother[j];
            if (isPrepositionBeforeWord(stringsAnother, j)) {
                strFromAnother = concatenatePrepositionWithWord(sb, stringsAnother, j);
                ++j;
            }
            if (isSimilar(key, strFromAnother)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrepositionBeforeWord(String[] strings, int strIndex) {
        return strings[strIndex].length() <= 3 && isNotLastIndex(strIndex, strings.length);
    }

    private boolean isNotLastIndex(int strIndex, int stringsArrLength) {
        return strIndex != stringsArrLength - 1;
    }

    private String concatenatePrepositionWithWord(StringBuilder sb, String[] strings, int index) {
        String result = sb.append(strings[index]).append(strings[index + 1]).toString();
        sb.setLength(0);
        return result;
    }
}
