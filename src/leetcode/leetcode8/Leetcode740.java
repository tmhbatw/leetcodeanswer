package leetcode.leetcode8;

public class Leetcode740 {

    public int deleteAndEarn(int[] nums) {
        int[] num=new int[10001];
        for(int cur:nums)
            num[cur]+=cur;

        for(int i=2;i<num.length;i++){
            num[i]=Math.max(num[i-2]+num[i],num[i-1]);
        }
        return num[10000];
    }
}
