package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1243 {

    public List<Integer> transformArray(int[] arr) {
        while(getChanged(arr)){

        };
        List<Integer> list=new ArrayList<>();
        for(int cur:arr)
            list.add(cur);
        return list;
    }

    private boolean getChanged(int[] arr){
        int[] num=arr.clone();
        boolean flag=false;
        for(int i=1;i<num.length-1;i++){
            if(num[i]>arr[i-1]&&num[i]>arr[i+1]) {
                num[i]--;
                flag=true;
            }
            if(num[i]<arr[i-1]&&num[i]<arr[i+1]) {
                num[i]++;
                flag=true;
            }
        }
        System.arraycopy(num,0,arr,0,arr.length);
        return flag;
    }
}
