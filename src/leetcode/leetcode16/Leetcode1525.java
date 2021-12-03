package leetcode.leetcode16;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1525 {

    public int numSplits(String s) {
        int[] right=new int[s.length()];
        Set<Character> set=new HashSet<>();
        for(int j=s.length()-1;j>=0;j--){
            set.add(s.charAt(j));
            right[j]=set.size();
        }

        int result=0;
        set=new HashSet<>();
        for(int i=0;i<s.length()-1;i++){
            set.add(s.charAt(i));
            if(set.size()==right[i+1])
                result++;
        }

        return result;
    }
}
