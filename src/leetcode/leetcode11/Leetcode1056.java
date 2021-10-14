package leetcode.leetcode11;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1056 {

    public boolean confusingNumber(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(6,9);
        map.put(0,0);
        map.put(1,1);
        map.put(8,8);
        map.put(9,6);

        int res=0;
        int num=n;
        while(num>0){
            int last=num%10;
            num/=10;
            if(!map.containsKey(last))
                return false;
            res=res*10+map.get(last);
        }
        return res==n;
    }
}
