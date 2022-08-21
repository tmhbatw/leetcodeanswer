package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode948 {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if(tokens.length==0||power<tokens[0])
            return 0;
        int i=0,j=tokens.length-1;
        int result=0;

        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i++];
                result++;
            }else{
                if(j-i<=1)
                    return result;
                result--;
                power+=tokens[j--];
            }
        }
        return result;
    }

}
