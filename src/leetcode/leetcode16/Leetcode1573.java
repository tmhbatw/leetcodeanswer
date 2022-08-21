package leetcode.leetcode16;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1573 {

    public int numWays(String s) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                l.add(i);
        }
        int mod=1000000007;
        if(l.size()==0){
            return (int) ((long)(s.length()-1)*(s.length()-2)/2%mod);
        }
        if(l.size()%3!=0)
            return 0;

        int index=l.size()/3;
        long result=(long)(l.get(index)-l.get(index-1))*(l.get(index*2)-l.get(index*2-1));
        return (int)(result%mod);
    }
}
