package leetcode.leetcode10;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode907 {

    public int sumSubarrayMins(int[] arr) {
        int[] right=new int[arr.length];
        Stack<int[]> s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.empty()&&s.peek()[0]>arr[i]){
                right[s.pop()[1]] = i;
            }
            s.add(new int[]{arr[i],i});
        }
        while(!s.empty()){
            right[s.pop()[1]]=arr.length;
        }
        int[] left=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.empty()&&s.peek()[0]>=arr[i]){
                left[s.pop()[1]]=i;
            }
            s.add(new int[]{arr[i],i});
        }
        while(!s.empty()){
            left[s.pop()[1]]=-1;
        }
        int mod=1000000007;

        int result=0;
        for(int i=0;i<arr.length;i++){
            long cur = arr[i]%mod;
            cur=(cur*(right[i]-i)%mod)*(i-left[i]);
            cur %=mod;
            result += cur;
            result%=mod;
        }
        return result;
    }

}
