package leetcode.leetcode2;

public class Leetcode137 {
    /*Description
    * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    * 说明：
    * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    * */

    public int singleNumber(int[] nums) {
        int[] number=new int[32];
        for(int cur:nums){
            for(int i=0;i<=31;i++)
                number[i]+=cur>>i&1;
        }
        return getNumber(number);
    }

    private int getNumber(int[] number){
        int result=0;
        int cur=1;
        for(int i=0;i<31;i++){
            result+=cur*(number[i]%3);
            cur*=2;
        }
        if(number[31]%3==1)
            return Integer.MIN_VALUE+result;
        return result;
    }

    public static void main(String[] args){
        int cur=-2;
        String curr=Integer.toBinaryString(cur);
        System.out.println(Integer.parseInt(curr,2));
        System.out.println(curr.length()+" "+curr);
    }
}
