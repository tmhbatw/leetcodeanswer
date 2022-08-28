package leetcode.leetcode18;

public class Leetcode1712 {

    public int waysToSplit(int[] nums) {
        int n=nums.length;
        long[] sum=new long[n+1];
        for(int i=0;i<n;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        long result=0;
        for(int i=0;i<n-2;i++){
            long cur=sum[i+1];

            int l=i+1,r=nums.length-2;
            while(l<r){
                int mid=(l+r)/2;
                if(sum[mid+1]-cur>=cur){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }

            if(sum[l+1]-cur<cur)
                continue;

            int l2=i+1,r2=nums.length-2;
            while(l2<r2){
                int mid=(l2+r2+1)/2;
                //System.out.println("mid is:"+mid+" "+(sum[n]-sum[mid+1])+" "+(sum[mid+1]-cur));
                if(sum[n]-sum[mid+1]>=sum[mid+1]-cur){
                    l2=mid;
                }else
                    r2=mid-1;
            }
            if(sum[n]-sum[l2+1]<sum[l2+1]-cur)
                continue;
            //System.out.println(i+" "+l+" "+l2);
            result+=Math.max(0,l2-l+1);
        }
        return (int)(result%1000000007);
    }
}
