package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return isSmall(c1,c2)||isSmall(c2,c1);
    }

    private boolean isSmall(char[] c1,char[] c2){
        for(int i=0;i<c1.length;i++){
            if(c1[i]>c2[i])
                return false;
        }
        return true;
    }
}
