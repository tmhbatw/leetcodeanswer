package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int l=0,r=arr.length;
        int[] last=getLast(arr);
        while(l<r){
            int mid=(l+r)/2;
            if(match(arr,mid,last)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean match(int[] arr,int mid,int[] last){
        for(int i=0;i<arr.length;i++){
            if(i>=1&&arr[i]<arr[i-1])
                break;
            //一共arr.length-mid个数，前面（i+1）个数，后面则（length-mid-i-1)个数
            //length-(length-mid-i-1)
            if(i==arr.length-mid-1||arr[i]<=last[mid+i+1])
                return true;
        }
        return last[mid]>Integer.MIN_VALUE;
    }

    private int[] getLast(int[] arr){
        int[] res=new int[arr.length];
        Arrays.fill(res,Integer.MIN_VALUE);
        for(int j=arr.length-1;j>=0;j--){
            if(j==arr.length-1||arr[j]<=arr[j+1]){
                res[j]=arr[j];
            }else{
                return res;
            }
        }
        return res;
    }
}
