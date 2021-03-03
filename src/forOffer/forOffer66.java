package forOffer;

public class forOffer66 {
    /*Description
    * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
    * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
    * */

    public int[] constructArr(int[] a) {
        int length=a.length;
        int[] res=new int[length];
        int[] dp=new int[length+1];
        dp[length]=1;
        for(int i=length-1;i>=0;i--){
            dp[i]=dp[i+1]*a[i];
        }
        int pre=1;
        for(int i=0;i<a.length;i++){
            res[i]=pre*dp[i+1];
            pre*=a[i];
        }
        return res;
    }
}
