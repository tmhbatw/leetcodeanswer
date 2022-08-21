package leetcode.leetcode16;

public class Leetcode1524 {

    public int numOfSubarrays(int[] arr) {
        int odd=0;
        int even=1;
        int cur=0;
        long result=0;
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            if(cur%2==1){
                result+=even;
                odd++;
            }else{
                result+=odd;
                even++;
            }
        }

        return (int)(result%mod);
    }

}
