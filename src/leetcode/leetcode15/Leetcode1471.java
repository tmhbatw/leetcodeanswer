package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1471 {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid=arr[(arr.length-1)/2];

        int i=0,j=arr.length-1;

        int[] res=new int[k];
        for(int index=0;index<k;index++){
            if(Math.abs(arr[i]-mid)>Math.abs(arr[j]-mid))
                res[index]=arr[i++];
            else
                res[index]=arr[j--];
        }
        return res;
    }

}
