package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result=new HashSet<>();

        List<Integer> l1=getList(x,bound),l2=getList(y,bound);
        for(int num1:l1){
            for(int num2:l2){
                if(num1+num2<=bound){
                    result.add(num1+num2);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private List<Integer> getList(int cur,int bound){
        List<Integer> list=new ArrayList<>();
        list.add(1);

        if(cur==1){
            return list;
        }

        int start=cur;
        while(start<=bound){
            list.add(start);
            start*=cur;
        }
        return list;
    }


}
