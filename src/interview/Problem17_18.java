package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem17_18 {

    public int[] shortestSeq(int[] big, int[] small) {
        int result=Integer.MAX_VALUE;
        int start=-1;
        int[] num=new int[small.length];

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<small.length;i++){
            map.put(small[i],i);
        }

        int j=0;
        for(int i=0;i<big.length;i++){
            while(j<big.length&&!isMatch(num)){
                if(map.containsKey(big[j])){
                    num[map.get(big[j])]++;
                }
                j++;
            }
            if(isMatch(num)){
                if(result>j-i){
                    result=j-i;
                    start=i;
                }
            }
            if(map.containsKey(big[i])){
                num[map.get(big[i])]--;
            }
        }

        return start==-1?new int[]{}:new int[]{start,start+result-1};
    }

    private boolean isMatch(int[] num){
        for(int cur:num){
            if(cur==0)
                return false;;
        }
        return true;
    }

}
