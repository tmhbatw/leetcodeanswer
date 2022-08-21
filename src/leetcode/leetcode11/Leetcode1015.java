package leetcode.leetcode11;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1015 {

    public int smallestRepunitDivByK(int k) {
        int result=1;
        int cur=1;
        boolean[] reached=new boolean[k];
        while(cur%k!=0){
            cur%=k;
            if(reached[cur])
                return -1;
            reached[cur]=true;
            cur=cur*10+1;
            result++;
        }
        return result;
    }


}
