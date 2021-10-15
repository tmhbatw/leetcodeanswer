package leetcode.leetcode15;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1496 {

    public boolean isPathCrossing(String path) {
        Set<Integer> set=new HashSet<>();
        int start=0;
        int end=0;
        set.add(start*10000+end);
        for(int i=0;i<path.length();i++){
            switch (path.charAt(i)){
                case 'N':
                    start+=1;
                    break;
                case 'E':
                    end+=1;
                    break;
                case 'S':
                    start-=1;
                    break;
                default:
                    end-=1;
            }
            if(set.contains(start*10000+end))
                return true;
            set.add(start*10000+end);
        }
        return false;
    }
}
