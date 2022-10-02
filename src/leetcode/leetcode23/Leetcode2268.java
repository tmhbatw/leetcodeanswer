package leetcode.leetcode23;

import java.util.Arrays;

public class Leetcode2268 {

    public int minimumKeypresses(String s) {
        int[] time=new int[26];
        for(char c:s.toCharArray())
            time[c-'a']++;

        int result=0;
        Arrays.sort(time);
        for(int j=25;j>=0;j--){
            result+=time[j]*((25-j)/9+1);
        }

        return result;
    }
}
