package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {

    public List<Integer> partitionLabels(String s) {
        int pre=-1;

        int max=0;
        int[] num=new int[128];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)]=i;

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            max=Math.max(num[s.charAt(i)],max);

            if(max==i){
                result.add(max-pre);
                pre=max;
            }
        }

        return result;
    }
}
