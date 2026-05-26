package Algorithms._136;

public class Solution {
  /*
  *----XOR
  * 100
  * 001
  * 010
  * 001
  * 010
  * ---
  * 100
  * */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}