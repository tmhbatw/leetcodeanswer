package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2165 {

    public long smallestNumber(long num) {
        if(num==0)
            return 0;
        if(num<0){
            num = -num;
            List<Long> list=new ArrayList<>();
            while(num>0){
                list.add(num%10);
                num/=10;
            }
            Collections.sort(list);
            for(int j=list.size()-1;j>=0;j--){
                num=num*10+list.get(j);
            }
            return -num;
        }

        List<Long> list=new ArrayList<>();
        long base=1;

        while(num>0){
            long cur=num%10;
            if(cur==0)
                base*=10;
            else
                list.add(num%10);
            num/=10;
        }
        Collections.sort(list);
        num=base*list.get(0);
        for(int i=1;i<list.size();i++){
            num=num*10+list.get(i);
        }
        return num;
    }
}
