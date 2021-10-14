package leetcode.leetcode12;

import java.util.Arrays;

public class Leetcode1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int res=0;
        int sum=5000;
        for(int i=0;i<weight.length;i++){
            sum-=weight[i];
            if(sum<0)
                return res;
            res++;
        }
        return res;
    }
}
