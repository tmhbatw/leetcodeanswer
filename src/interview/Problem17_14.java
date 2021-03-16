package interview;

import java.util.Arrays;

public class Problem17_14 {
    /*Description
    *设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
    * */

    public int[] smallestK(int[] arr, int k) {
        if(k==0)
            return new int[0];
        sort(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);
    }

    private void sort(int[] arr,int start,int end,int k){
        int cur=arr[start];
        int left=start+1,right=end;
        while(left<right){
            if(arr[left]<cur) {
                left++;
                continue;
            }
            if(arr[right]>=cur){
                right--;
                continue;
            }
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        if(arr[left]>=cur)
            left--;
        arr[start]=arr[left];
        arr[left]=cur;
        if(left==k-1)
            return;
        if(left<k-1){
            sort(arr,left+1,end,k);
        }else
            sort(arr,start,left-1,k);
    }
}
