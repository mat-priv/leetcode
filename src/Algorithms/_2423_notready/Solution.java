package Algorithms._2423_notready;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public boolean equalFrequency(String word) {
        char[] inputArray = word.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        Character tempChar = null;
        for (int i = 0; i < inputArray.length; i++) {
            tempChar = inputArray[i];
            Integer tempCharVal = charMap.get(tempChar);
            if (tempCharVal == null) {
                charMap.put(tempChar, 1);
            } else {
                charMap.put(tempChar, tempCharVal + 1);
            }
        }

        List<Integer> valuesList = new ArrayList<>(charMap.values().stream().toList());

        for (int i = 0; i < valuesList.size(); i++) {
            Integer temp = valuesList.get(i)-1;
            valuesList.set(i, temp);
            if(valuesList.stream().filter(val -> val >0).collect(Collectors.toSet()).size() == 1) return true;
            valuesList.set(i, temp+1);
        }

        return false;
    }
}