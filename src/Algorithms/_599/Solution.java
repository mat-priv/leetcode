package Algorithms._599;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    resultMap.put(list1[i], i + j);
                }
            }
        }

        int smallest = resultMap.values().stream()
                .min(Integer::compareTo)
                .orElse(0);

        return resultMap.entrySet().stream()
                .filter(e -> e.getValue() == smallest)
                .map(e -> e.getKey())
                .toArray(String[]::new);
    }
}