package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1794 {

    public int countQuadruples(String firstString, String secondString) {
        int[] num=new int[26];
        Arrays.fill(num,-1);
        for(int j=firstString.length()-1;j>=0;j--){
            num[firstString.charAt(j)-'a']=j;
        }

        int result=Integer.MAX_VALUE;
        int count=0;
        for(int j=0;j<secondString.length();j++){
            int index=secondString.charAt(j)-'a';
            if(num[index]!=-1){
                if(num[index]-j<result){
                    result=num[index]-j;
                    count=0;
                }
                if(num[index]-j==result)
                    count++;
            }
        }

        return count;
    }
}
