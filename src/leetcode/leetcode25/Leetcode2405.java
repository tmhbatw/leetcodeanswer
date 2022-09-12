package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2405 {

    public int partitionString(String s) {
        int[] num=new int[26];
        int result = 1;
        for(int i=0;i<s.length();i++){
            int i1 = s.charAt(i) - 'a';
            if(num[i1] ==1){
                num=new int[26];
                result++;
            }
            num[i1]++;
            // System.out.println(Arrays.toString(num)+" "+result);
        }
        return result ;
    }


}
