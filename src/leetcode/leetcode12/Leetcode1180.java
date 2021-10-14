package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1180 {

    public int countLetters(String s) {
        List<Integer> list=new ArrayList<>();
        int length=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<length-1&&s.charAt(i+1)==cur)
                i++;
            list.add(i-start+1);
        }
        int count=0;
        for(int cur:list){
            count+=(cur)*(cur+1)/2;
        }
        return count;
    }
}
