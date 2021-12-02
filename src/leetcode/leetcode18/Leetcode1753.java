package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1753 {

    public int maximumScore(int a, int b, int c) {
        int[] num=new int[]{a,b,c};
        Arrays.sort(num);

        if(num[0]+num[1]<=num[2])
            return num[0]+num[1];

        int diff=num[0]+num[1]-num[2];
        return diff/2+num[2];
    }
}
