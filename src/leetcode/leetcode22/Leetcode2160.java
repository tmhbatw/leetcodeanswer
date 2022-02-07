package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2160 {

    public int minimumSum(int num) {
        List<Integer> list=new ArrayList<>();
        while(num>0){
            int cur=num%10;
            num/=10;
            if(cur>0)
                list.add(cur);
        }

        Collections.sort(list);
        int result=0;
        int base=1;
        for(int j=list.size()-1;j>=0;j-=2){
            result+=list.get(j)*base;
            if(j>=1)
                result+=list.get(j-1)*base;
            base*=10;
        }

        return result;
    }
}
