package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1414 {


    public int findMinFibonacciNumbers(int k) {
        List<Integer> list=new ArrayList<>();

        int i1=0,i2=1;
        for(int i=1;i<44;i++){
            int cur=i1+i2;
            i1=i2;
            i2=cur;
            list.add(cur);
        }

        int result=0;
        for(int j=list.size()-1;j>=0;j--){
            if(k>=list.get(j)) {
                k -= list.get(j);
                result++;
            }
        }
        return result;
    }

}
