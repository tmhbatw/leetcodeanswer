package leetcode.leetcode9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode823 {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Long> map=new HashMap<>();
        long result = 0;
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            long cur = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]%arr[j]==0&&map.containsKey(arr[i]/arr[j])){
                    cur += map.get(arr[j])*map.get(arr[i]/arr[j]);
                    cur%=mod;
                }
            }
            result+=cur;
            result%=mod;
            map.put(arr[i],cur);
        }
        return (int) result;
    }

}
