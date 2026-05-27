package Algorithms._191;

class Solution {
    public static int hammingWeight(int n) {
        int result = 0;

        while (n != 0) {
            if (n % 2 != 0) result++;
            n = n / 2;
        }

        return result;
    }

    static void main() {
        System.out.println(hammingWeight(2147483645));
    }
}