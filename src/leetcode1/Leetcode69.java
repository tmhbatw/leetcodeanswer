package leetcode1;

public class Leetcode69 {
    /*Description
    * 实现int sqrt(int x)函数。
    * 计算并返回x的平方根，其中x 是非负整数。
    * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    * */

    public int mySqrt(int x) {
        int left=0,right=46340;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid>x){
                right=mid-1;
            }else if(mid==46340||(mid+1)*(mid+1)>x)
                return mid;
            else
                left=mid+1;
        }
        return left;
    }

    public static void main(String[] args){
        System.out.println(new Leetcode69().mySqrt(Integer.MAX_VALUE));
    }
}
