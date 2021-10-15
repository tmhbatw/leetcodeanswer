package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1556 {

    public String thousandSeparator(int n) {
        if(n==0)
            return "0";
        List<Integer> list=new ArrayList<>();
        while(n>0){
            list.add(n%1000);
            n/=1000;
        }
        StringBuilder sb=new StringBuilder();
        for(int j=list.size()-1;j>=0;j--){
            String curVal=list.get(j)+"";
            if(j<list.size()-1){
                while(curVal.length()<3)
                    curVal="0"+curVal;
            }
            sb.append(".").append(curVal);
        }
        return sb.substring(1);
    }
}
