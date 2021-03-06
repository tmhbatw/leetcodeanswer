package interview;

import java.util.Arrays;

public class Problem16_16 {
    /*Description
    *给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
    * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]

    * */

    public int[] subSort(int[] array) {
        int[] num=array.clone();
        Arrays.sort(num);
        int n=num.length-1;
        for(;n>=0;n--){
            if(num[n]!=array[n])
                break;
        }
        if(n==-1)
            return new int[]{-1,-1};
        int m=0;
        for(;m<num.length;m++){
            if(num[m]!=array[m])
                break;
        }
        return new int[]{m,n};
    }
}
