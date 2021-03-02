package forOffer;

public class forOffer51 {
    /*Description
    * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    * */

    /*Solution
    * 归并排序的同时即可进行逆序对的计算
    * */

    public int reversePairs(int[] nums) {
        return mergeSort(nums,new int[nums.length],0,nums.length-1);
    }

    private int mergeSort(int[] nums,int[] temp,int start,int end){
        if(end<start)
            return 0;
        if(end==start){
            temp[start]=nums[start];
            return 0;
        }
        int mid=start+(end-start)/2;
        int res=mergeSort(nums,temp,start,mid)+mergeSort(nums,temp,mid+1,end);
        if(nums[mid]<nums[mid+1])
            return res;
        int i=start,j=mid+1;
        int k=start;
        while(k<=end){
            int val1=i<=mid?nums[i]:Integer.MAX_VALUE;
            int val2=j<=end?nums[j]:Integer.MAX_VALUE;
            if(val1<=val2)
                temp[k++]=nums[i++];
            else{
                temp[k++]=nums[j++];
                res+=mid-i+1;
            }
        }
        for(int l=start;l<=end;l++)
            nums[l]=temp[l];
        return res;
    }
}
