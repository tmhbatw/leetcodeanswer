package leetcode.leetcode20;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1933 {

    public boolean isDecomposable(String s) {
        List<Integer> list=new ArrayList<>();
        int length=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<length-1&&s.charAt(i+1)==cur)
                i++;
            list.add(i-start+1);
        }
        return getRes(list);
    }

    private boolean getRes(List<Integer> list){
        int count=0;
        for(int cur:list){
            switch (cur%3){
                case 1:
                    return false;
                case 2:
                    count++;
            }
        }
        return count==1;
    }
}
