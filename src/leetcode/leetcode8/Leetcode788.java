package leetcode.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class Leetcode788 {
    /*Description
    * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
    * 如果一个数的每位数字被旋转以后仍然还是一个数字，则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
    * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
    * 现在我们有一个正整数N, 计算从1 到N 中有多少个数X 是好数？
    * */

    public int rotatedDigits(int N) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(2,5);
        map.put(0,0);
        map.put(1,1);
        map.put(8,8);
        map.put(6,9);
        map.put(9,6);
        map.put(5,2);
        int result=0;
        for(int i=1;i<=N;i++){
            int cur=i;
            int curr=0;
            int count=1;
            boolean flag=true;
            while(cur>0){
                int left=cur%10;
                if(!map.containsKey(left)) {
                    flag=false;
                    break;
                }
                curr+=map.get(left)*count;
                count*=10;
                cur/=10;
            }
            if(curr!=i&&flag){
                result++;
            }
        }
        return result;
    }
}
