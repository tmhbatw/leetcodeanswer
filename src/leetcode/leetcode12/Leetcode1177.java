package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int length=s.length();
        int[][] num=new int[length+1][26];
        for(int i=0;i<s.length();i++){
            num[i+1]=num[i].clone();
            num[i+1][s.charAt(i)-'a']++;
        }

        List<Boolean> result=new ArrayList<>();
        for(int[] q:queries){
            result.add(getRes(num[q[0]],num[q[1]],q[2]));
        }
        return result;
    }

    private boolean getRes(int[] c1,int[] c2,int k){
        int count = 0;
        for(int i=0;i<26;i++)
            count += (c2[i]-c1[i])%2==1?1:0;
        return count/2<=k;
    }



}
