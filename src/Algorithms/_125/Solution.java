package Algorithms._125;

public class Solution {
    public boolean isPalindrome(String s) {
        String input = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}