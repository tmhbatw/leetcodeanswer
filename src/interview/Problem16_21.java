package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem16_21 {
    /*Description
    * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
    * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
    *
    * */


    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum=0;
        for(int cur:array1)
            sum+=cur;
        Set<Integer> set=new HashSet<>();
        for(int cur:array2){
            sum-=cur;
            set.add(cur);
        }
        if(sum%2!=0)
            return new int[0];
        sum/=2;
        for(int cur:array1){
          if(set.contains(cur-sum))
              return new int[]{cur,cur-sum};
        }
        return new int[0];
    }


}
