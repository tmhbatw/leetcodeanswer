package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int count=0;
        for(int j=num.length-1;j>=0;j--){
            int cur=k%10;
            k/=10;
            num[j]+=cur+count;
            count=num[j]/10;
            num[j]%=10;
        }
        List<Integer> list=new ArrayList<>();
        while(count!=0||k!=0){
            int cur=k%10;
            k/=10;
            int curVal=cur+count;
            count=curVal/10;
            curVal%=10;
            list.add(0,curVal);
        }
        for(int cur:num)
            list.add(cur);
        return list;
    }
}
