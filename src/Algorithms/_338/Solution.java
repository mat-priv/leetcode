package Algorithms._338;

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i / 2] + 1;
        }

        return result;
    }
}