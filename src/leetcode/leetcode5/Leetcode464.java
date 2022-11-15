package leetcode.leetcode5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode464 {

    boolean[] reached;
    boolean[] result;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> set=new HashSet<>();
        reached=new boolean[1<<maxChoosableInteger];
        result=new boolean[1<<maxChoosableInteger];
        for(int i=1;i<=maxChoosableInteger;i++)
            set.add(i);
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal)
            return false;
        return canIWin(set,desiredTotal,0,(1<<maxChoosableInteger)-1);
    }

    private boolean canIWin(Set<Integer> set,int total,int cur,int status){
        if(reached[status])
            return result[status];
        reached[status]=true;

        Set<Integer> curSet=new HashSet<>(set);
        for(int num:curSet){
            if(cur+num>=total){
                result[status]=true;
                return true;
            }
            set.remove(num);
            status -= 1<<(num-1);
            boolean next=canIWin(set,total,cur+num,status);
            set.add(num);
            status+=1<<(num-1);
            if(!next){
                result[status]=true;
                return true;
            }
        }

        return false;
    }
}
