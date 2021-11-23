package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result=new ArrayList<>();

        for(int j=arr.length-1;j>=0;j--){

            int max=arr[j];
            int index=j;
            for(int i=0;i<j;i++){
                if(arr[i]>max){
                    max=arr[i];
                    index=i;
                }
            }
            if(index==j)
                continue;
            if(index!=0) {
                swap(arr, index);
                result.add(index+1);
            }
            swap(arr,j);
            result.add(j+1);

        }
        return result;
    }

    private void swap(int[] arr,int i){
        int l=0,r=i;
        while(l<r){
            int temp=arr[l];
            arr[l++]=arr[r];
            arr[r--]=temp;
        }
    }
}
