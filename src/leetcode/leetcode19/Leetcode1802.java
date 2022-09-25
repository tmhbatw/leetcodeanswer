package leetcode.leetcode19;

public class Leetcode1802 {

    public int maxValue(int n, int index, int maxSum) {
        int l=1,r=maxSum;
        while(l<r){
            int mid=(l+r+1)/2;
            if(match(mid,n,index,maxSum))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    public boolean match(long mid,int n,int index,int maxSum){
        long count = 0;
        long startl=Math.max((mid-index),1);
        count += Math.max(0,index-mid+1);
        count +=(startl+mid)*(mid-startl+1)/2;

        long startr=Math.max(1,(mid-(n-1-index)));
        count += Math.max(0,(n-1-index)-(mid-startr));

        count += (startr+mid-1)*(mid-startr)/2;
        return count<=maxSum;
    }
}
