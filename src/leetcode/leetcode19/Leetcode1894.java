package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1894 {

    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int num:chalk){
            sum+=num;
        }
        k%=sum;
        for(int i=0;i<chalk.length;i++){
            if(k<chalk[i])
                return i;
            k-=chalk[i];
        }
        return -1;
    }
}
