package leetcode.leetcode22;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2135 {

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set=new HashSet<>();
        int[] time=new int[26];
        for(int i=0;i<26;i++)
            time[i]=1<<i;

        for(String word:startWords){
            int cur=0;
            for(char c:word.toCharArray())
                cur+=time[c-'a'];
            set.add(cur);
        }

        int count = 0;
        for(String word:targetWords){
            int cur=0;
            for(char c:word.toCharArray())
                cur+=time[c-'a'];
            for(int i=0;i<26;i++){
                if((cur&time[i])>0&& set.contains(cur-time[i])) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }


}
