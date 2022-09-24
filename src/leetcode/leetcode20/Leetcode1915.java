package leetcode.leetcode20;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1915 {

    public long wonderfulSubstrings(String word) {
        int[] map=new int[1024];
        map[0]=1;
        int cur = 0;
        long result = 0;
        for(int i=0;i<word.length();i++){
            cur  ^= 1<<(word.charAt(i)-'a');
            //至多有一位不同
            result += map[cur];
            for(int j=0;j<10;j++){
                int val = cur^(1<<j);
                result += map[val];
            }

            map[cur]++;
        }

        return result;
    }


}
