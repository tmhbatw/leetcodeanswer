package leetcode.leetcode5;

public class Leetcode441 {
    /*Description
    * 你总共有n枚硬币，你需要将它们摆成一个阶梯形状，第k行就必须正好有k枚硬币。
    * 给定一个数字n，找出可形成完整阶梯行的总行数。
    * n是一个非负整数，并且在32位有符号整型的范围内。
    * */

    public int arrangeCoins(int n) {
        int left=0,right=65535;
        while(left<=right){
            int mid=left+(right-left)/2;
            long cur=(long)(mid)*(mid+1)/2;
            if(cur>n)
                right=mid-1;
            else if((long)(mid+1)*(mid+2)/2>n)
                return mid;
            else
                left=mid+1;
        }
        return left;
    }

    public static void main(String[] args){
        System.out.println(65535*1.0/2*65534);
        System.out.println(Integer.MAX_VALUE);
    }
}
