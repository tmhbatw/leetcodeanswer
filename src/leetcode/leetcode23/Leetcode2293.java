package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2293 {

    public int minMaxGame(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums)
            list.add(num);

        while(list.size()>1){
            List<Integer> newList=new ArrayList<>();
            boolean small = true;
            for(int i=0;i<list.size();i+=2){
                if(small)
                    newList.add(Math.min(list.get(i),list.get(1+i)));
                else
                    newList.add(Math.max(list.get(i),list.get(i+1)));

                small = !small;
            }

            list=newList;
        }

        return list.get(0);
    }

    public static void main(String[] args){
        System.out.println("hello world");
    }
}
