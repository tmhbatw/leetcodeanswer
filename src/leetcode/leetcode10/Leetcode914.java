package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode914 {
    public boolean hasGroupsSizeX(int[] deck) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(deck);
        int length=deck.length;
        for(int i=0;i<length;i++){
            int start=i;
            while(i<length-1&&deck[i+1]==deck[i]){
                i++;
            }
            list.add(i-start+1);
        }
        int pre=list.get(0);
        for(int i=1;i<list.size();i++)
            pre=getMax(Math.max(pre,list.get(i)),Math.min(pre,list.get(i)));
        return pre>=2;
    }

    private int getMax(int a,int b){
        if(a%b==0)
            return b;
        return getMax(b,a%b);
    }
}
