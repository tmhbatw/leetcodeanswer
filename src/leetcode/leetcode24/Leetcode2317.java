package leetcode.leetcode24;

public class Leetcode2317 {

    public int maximumXOR(int[] nums) {
        int result = 0;
        for(int num:nums)
            result |= num;

        return result;
    }

}
