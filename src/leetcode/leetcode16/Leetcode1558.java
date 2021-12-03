package leetcode.leetcode16;

public class Leetcode1558 {

    public int minOperations(int[] nums) {
        int res=0;
        int max=0;
        for(int num:nums){
            int[] c=getRes(num);
            res+=c[0];
            max=Math.max(max,c[1]);
        }
        return res+max;
    }

    private int[] getRes(int cur){
        int c1=0;
        int c2=0;
        while(cur>0){
            if(cur%2==1){
                cur--;
                c1++;
            }else{
                c2++;
                cur/=2;
            }
        }
        return new int[]{c1,c2};
    }
}
