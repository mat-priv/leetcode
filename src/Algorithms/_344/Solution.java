package Algorithms._344;

public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char charB = s[i];
            char charE = s[s.length - 1 - i];
            s[i] = charE;
            s[s.length - 1 - i] = charB;
        }
        System.out.println(s);
    }
}