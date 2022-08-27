package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode949 {

    public String largestTimeFromDigits(int[] arr) {
        for(int hour=23;hour>=0;hour--){
            int min=getRes(hour,arr);
            if(min==-1)
                continue;

            return (hour<10?"0":"")+hour+":"+(min<10?"0":"")+min;
        }
        return "";
    }

    private int getRes(int hour, int[] arr){
        int num1=hour/10,num2=hour%10;
        List<Integer> l=new ArrayList<>();
        for(int num:arr){
            l.add(num);
        }
        if(!l.contains(num1)||!l.contains(num2))
            return -1;
        for(int j=3;j>=0;j--){
            if(l.get(j)==num1){
                l.remove(j);
                break;
            }
        }
        for(int j=2;j>=0;j--){
            if(l.get(j)==num2){
                l.remove(j);
                break;
            }
        }
        if(l.size()!=2)
            return -1;
        int min=Math.min(l.get(0),l.get(1));
        int max=Math.max(l.get(0),l.get(1));
        int cur = max*10+min;
        if(max>=6){
            cur=min*10+max;
        }
        if(cur>=60)
            return -1;
        return cur;
    }
}
