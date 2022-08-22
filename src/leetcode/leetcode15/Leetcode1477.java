package leetcode.leetcode15;

public class Leetcode1477 {

    public int minSumOfLengths(int[] arr, int target) {
        int[] cur=new int[arr.length+1];
        int j=0;
        int curSum=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];
            while(curSum>target){
                curSum-=arr[j++];
            }
            if(curSum==target){
                int count=i-j+1;
                if(cur[j]!=0){
                    result=Math.min(count+cur[j],result);

                }
                cur[i+1]=cur[i]==0?count:Math.min(cur[i],count);
            }else{
                cur[i+1]=cur[i];
            }
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}
