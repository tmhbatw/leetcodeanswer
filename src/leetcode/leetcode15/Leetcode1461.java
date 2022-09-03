package leetcode.leetcode15;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1461 {

    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set=new HashSet<>();
        int expectSize= (int) Math.pow(2,k-1);
        int cur = 0;
        for(int i=0;i<s.length();i++){
            cur=cur*2+s.charAt(i)-'0';
            if(i>=k-1){
                set.add(cur);
                cur&=(expectSize-1);
                //System.out.println(cur);
            }
        }
        //System.out.println(set);
        return set.size()==expectSize*2;
    }

}
