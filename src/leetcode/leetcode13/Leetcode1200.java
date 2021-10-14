package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<min){
                min=arr[i]-arr[i-1];
                result=new ArrayList<>();
            }
            if(arr[i]-arr[i-1]==min){
                List<Integer> list=new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                result.add(list);
            }
        }
        return result;
    }
}
