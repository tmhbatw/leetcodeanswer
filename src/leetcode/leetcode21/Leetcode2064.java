package leetcode.leetcode21;

public class Leetcode2064 {

    public int minimizedMaximum(int n, int[] quantities) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(match(n,quantities,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        return l;
    }

    private boolean match(int n,int[] nums,int mid){
        long count = 0;
        for(int num:nums){
            count += (num-1)/mid+ 1;
        }
        return count<=n;
    }

}
