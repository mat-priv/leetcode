package Algorithms._824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String toGoatLatin(String sentence) {
        String ma = "ma";
        List<String> listOfWords = Arrays.stream(sentence.split(" ")).toList();

        StringBuilder result = new StringBuilder();

        Set<Character> rules = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        for (int i = 0; i < listOfWords.size(); i++) {
            String currentWord = listOfWords.get(i);
            if (rules.contains(currentWord.toCharArray()[0])) {
                result.append(currentWord)
                        .append(ma);

            } else {
                result.append(currentWord.substring(1))
                        .append(currentWord.toCharArray()[0])
                        .append(ma);
            }
            for (int j = 0; j <= i; j++) {
                result.append('a');
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}