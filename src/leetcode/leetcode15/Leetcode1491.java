package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1491 {

    public double average(int[] salary) {
        int sum= Arrays.stream(salary).sum();
        sum-=Arrays.stream(salary).min().getAsInt()+Arrays.stream(salary).max().getAsInt();
        return (sum*1.0)/(salary.length-2);
    }
}
