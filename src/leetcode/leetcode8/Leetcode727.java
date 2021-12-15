package leetcode.leetcode8;

import java.util.Arrays;

public class Leetcode727 {

    //动态规划
    public String minWindow(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();

        int[][] res=new int[l2+1][l1+1];
        for(int i=1;i<res.length;i++)
            Arrays.fill(res[i],1000000);

        for(int j=0;j<l2;j++){
            for(int i=0;i<l1;i++){
                if(s1.charAt(i)==s2.charAt(j)){
                    res[j+1][i+1]=Math.min(res[j][i],res[j+1][i])+1;
                }else
                    res[j+1][i+1]=res[j+1][i]+1;
            }
        }

        int l=Integer.MAX_VALUE;
        int end=0;
        for(int j=0;j<res[l2].length;j++){
            if(res[l2][j]<l){
                l=res[l2][j];
                end=j;
            }
        }
        return l>=1000000?"":s1.substring(end-l,end);
    }
}
