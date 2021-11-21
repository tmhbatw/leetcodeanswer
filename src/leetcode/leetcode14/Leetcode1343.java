package leetcode.leetcode14;

public class Leetcode1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result=0;

        int curSum=0;
        threshold*=k;
        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];

            if(i<k-1)
                continue;
            if(curSum>=threshold)
                result++;


            curSum-=arr[i-k+1];
        }
        return result;
    }
}
