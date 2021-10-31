package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int max=0;
        int base=1;
        boolean left=false;
        while(label>max){
            max+=base;
            base*=2;
            left=!left;
        }
        base/=2;
        int index=max-label;
        if(left)
            index=base-index-1;


        List<Integer> result=new ArrayList<>();
        while(max>=1){
            if(left){
                result.add(max-base+index+1);
            }else{
                result.add(max-index);
            }
            index/=2;
            max-=base;
            base/=2;
            left=!left;
        }

        Collections.reverse(result);

        return result;
    }
}
