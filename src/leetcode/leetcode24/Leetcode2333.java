package leetcode.leetcode24;

public class Leetcode2333 {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] num=new int[nums1.length];
        for(int i=0;i<num.length;i++)
            num[i]=Math.abs(nums1[i]-nums2[i]);

        int k = k1+k2;
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(match(num,k,mid))
                r=mid;
            else
                l=mid+1;
        }

        if(l==0)
            return 0;

        for(int cur:num)
            k-=Math.max(0,cur-l);
        long result = 0;
        for(int cur:num){
            long res=Math.min(cur,l);
            if(res==l&&k>0){
                res--;
                k--;
            }
            result += res *res;
        }
        return result;
    }

    private boolean match(int[] num,int k,int mid){
        for(int cur:num){
            if(cur>mid){
                k-=(cur-mid);
                if(k<0)
                    return false;
            }
        }

        return true;
    }
}
