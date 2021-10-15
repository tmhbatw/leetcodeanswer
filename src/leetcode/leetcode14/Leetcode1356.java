package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1356 {

    public int[] sortByBits(int[] arr) {
        List<Integer> list=new ArrayList<>();
        for(int cur:arr)
            list.add(cur);
        list.sort((o1,o2)->{
            int number1=getZeroNumber(o1);
            int number2=getZeroNumber(o2);
            if(number1==number2)
                return o1-o2;
            return number1-number2;
        });
        for(int i=0;i<arr.length;i++)
            arr[i]=list.get(i);
        return arr;
    }

    private int getZeroNumber(int cur){
        int count=0;
        while(cur>0){
            count+=(cur%2);
            cur/=2;
        }
        return count;
    }
}
