package leetcode.leetcode17;

public class Leetcode1608 {

    public int specialArray(int[] nums) {
        int[] number=new int[1001];
        for(int cur:nums)
            number[cur]++;
        for(int i=999;i>=0;i--)
            number[i]+=number[i+1];
        for(int i=1000;i>=0;i--){
            if(number[i]==i)
                return i;
        }
        return -1;
    }
}
