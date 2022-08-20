package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1657 {

    public boolean closeStrings(String word1, String word2) {
        int[] r1=getRes(word1);
        int[] r2=getRes(word2);
        for(int i=0;i<r1.length;i++){
            if(r1[i]==0&&r2[i]!=0)
                return false;
        }
        Arrays.sort(r1);
        Arrays.sort(r2);

        return Arrays.equals(r1, r2);
    }

    private int[] getRes(String word){
        int[] res=new int[26];
        for(char c:word.toCharArray())
            res[c-'a']++;
        return res;
    }

}
