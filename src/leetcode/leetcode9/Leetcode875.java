package leetcode.leetcode9;

public class Leetcode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(piles,mid,h))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean isMatch(int[] piles,int mid, int h){
        long count=0;
        for(int num:piles){
            count+=(num-1)/mid+1;
        }
        return count<=h;
    }
}
