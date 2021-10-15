package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1399 {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int cur=getNumber(i);
            map.putIfAbsent(cur,0);
            map.put(cur,map.get(cur)+1);
        }
        int result=0;
        int time=0;
        System.out.println(map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>time) {
                time = entry.getValue();
                result=0;
            }
            if(entry.getValue()==time)
                result++;
        }
        return result;
    }

    private int getNumber(int n){
        int res=0;
        while(n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
}
