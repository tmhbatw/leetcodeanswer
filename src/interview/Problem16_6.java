package interview;

import java.util.Arrays;

public class Problem16_6 {
    /*Description
    * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     * */

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int index1=0,index2=0;
        int length1=a.length,length2=b.length;
        int result=Integer.MAX_VALUE;
        while(index1<a.length&&index2<b.length){
            if(a[index1]==b[index2])
                return 0;
            if(a[index1]>b[index2]){
                long dif=(long)a[index1]-b[index2++];
                if(dif>Integer.MAX_VALUE)
                    continue;
                result=(int)Math.min(dif,result);
            }else {
                long dif=(long)b[index2]-a[index1++];
                if(dif>Integer.MAX_VALUE)
                    continue;
                result=(int)Math.min(dif,result);
            }
        }
        return result;
    }
}
