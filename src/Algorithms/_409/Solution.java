package Algorithms._409;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        boolean oddVal = false;
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            map.merge(chars[i], 1, Integer::sum);
        }

        List<Integer> counts = map.values().stream().toList();

        for (int i = 0; i < counts.size(); i++) {

            if (counts.get(i) % 2 == 0) {
                result += counts.get(i);
            } else {
                result += counts.get(i) / 2 * 2;
                oddVal = true;
            }
        }

        if (oddVal) result++;


        return result;
    }
}