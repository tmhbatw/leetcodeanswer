package leetcode.leetcode19;

public class Leetcode1829 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int sum=0;
        for(int cur:nums)
            sum^=cur;
        int length=nums.length;
        int[] res=new int[length];
        for(int i=0;i<length;i++){
            res[i]=getRes(sum,maximumBit);
            sum^=nums[length-i-1];
        }
        return res;
    }

    private int getRes(int cur,int max){
        String num=Integer.toBinaryString(cur);
        while(max-num.length()>0)
            num="0"+num;
        int base=1;
        int result=0;
        for(int j=num.length()-1;j>=Math.max(0,num.length()-max);j--){
            if(num.charAt(j)=='0')
                result+=base;
            base*=2;
        }
        return result;
    }

}
