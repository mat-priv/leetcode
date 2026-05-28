package Algorithms._6m_notready;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static String convert(String s, int numRows) {

        if (numRows >= s.length()) return s;
        StringBuilder sb = new StringBuilder();

        List<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }


        int numberOfElementsInLoop = (numRows * 2 - 2);
        int loops = s.length() / numberOfElementsInLoop + 1;

        for (int i = 0; i < loops; i++) {
            for (int j = 0; j < numberOfElementsInLoop; j++) {
                if (i + j + 1 > s.length()) continue;
                if (j >= numRows) {
                    stringBuilders.get(numRows - (j - numRows)-1).append(s.substring(i + j, i + j + 1));
                } else {
                    stringBuilders.get(j).append(s.substring(i + j, i + j + 1));
                }
            }
        }

//        for (int i = 0; i < numRows; i++) {
//            int pos = i - numRows;
//            while (pos <= s.length()) {
//                sb.append(s.substring(pos, pos + 1));
//                pos += numRows;
//            }
//        }


        return stringBuilders.stream()
                .map(sbb -> sbb.toString())
                .collect(Collectors.joining());
    }

    static void main() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}