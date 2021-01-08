package leetcode3;

public class Leetcode201 {
    /*Description
    *给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
    * */

    /*Solution
    * 可以转化为求m与n的最大公共前缀和
    * */
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n)
            return m;
        int result=0;
        for(int i=30;i>=0;i--){
            if(((m>>i)&1)==((n>>i)&1)){
                result+=(1<<i)*((m>>i)&1);
            }else
                return result;
        }
        return result;
    }

    public static void main(String[] args){
        int number= (int) Math.pow(2,30);
        System.out.println(new Leetcode201().rangeBitwiseAnd(1,1));
    }
}
