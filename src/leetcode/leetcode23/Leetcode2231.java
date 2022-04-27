package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode2231 {
    public int largestInteger(int num) {
        List<Integer> list=new ArrayList<>();
        while(num>0){
            list.add(num%10);
            num/= 10;
        }
        Collections.reverse(list);

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        for(int n:list){
            if(n%2==0){
                l1.add(n);
            }
            else{
                l2.add(n);
            }
        }
        Collections.sort(l1,Collections.reverseOrder());
        Collections.sort(l2,Collections.reverseOrder());
        int i1=0, i2=0;
        int result=0;
        for(int n:list){
            if(n%2==0){
                result = result*10 +l1.get(i1++);
            }
            else
                result = result*10+l2.get(i2++);
        }
        return result;
    }
}
