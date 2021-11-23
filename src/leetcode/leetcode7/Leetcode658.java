package leetcode.leetcode7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        if(arr[0]>=x){
            for(int i=0;i<k;i++)
                result.add(arr[i]);
            return result;
        }

        //arr数组中一定有比x小的数
        int l=0,r=arr.length-1;
        while(l<r){
            int mid=(l+r+1)/2;
            if(arr[mid]<=x)
                l=mid;
            else
                r=mid-1;
        }
        r=l+1;
        while(k-->0){
            int valR=r<arr.length?arr[r]:10000000;
            int valL=l>=0?arr[l]:-1000000;
            if(valR-x<x-valL){
                result.add(arr[r++]);
            }else
                result.add(arr[l--]);
        }
        Collections.sort(result);
        return result;
    }
}
