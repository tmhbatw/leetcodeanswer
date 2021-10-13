package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode830 {


    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list=new ArrayList<>();
        int length=s.length();
        for(int i=0;i<s.length();i++){
            int start=i;
            char c=s.charAt(i);
            while(i<length-1&&s.charAt(i+1)==c)
                i++;
            if(i-start>=2){
                List<Integer> cur=new ArrayList<>();
                cur.add(start);
                cur.add(i);
                list.add(cur);
            }
        }
        return list;
    }
}
