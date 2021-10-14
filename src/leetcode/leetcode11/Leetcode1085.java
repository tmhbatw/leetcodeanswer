package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1085 {

    public int sumOfDigits(int[] nums) {
        int min= Arrays.stream(nums).min().getAsInt();
        int result=0;
        while(min>0){
            result+=min%10;
            min/=10;
        }
        return (result+1)%2;
    }
}
