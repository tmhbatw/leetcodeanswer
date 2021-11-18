package leetcode.leetcode15;

public class Leetcode1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
            return -1;
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(match(bloomDay,m,k,mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean match(int[] bloom,int m,int k,int mid){
        int count=0;
        int pre=-1;
        for(int i=0;i<bloom.length;i++){
            if(bloom[i]>mid){
                count+=(i-pre-1)/k;
                pre=i;
            }
        }
        count+=(bloom.length-pre-1)/k;
        return count>=m;
    }
}
