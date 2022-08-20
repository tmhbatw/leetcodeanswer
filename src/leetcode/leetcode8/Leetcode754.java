package leetcode.leetcode8;

import java.lang.reflect.Parameter;

public class Leetcode754 {


    public int reachNumber(int target) {
        target=Math.abs(target);
        int l=1,r=Integer.MAX_VALUE;
        while(l<r) {
            int mid=l+(r-l)/2;
            if((long)(mid)*(mid+1)/2>=target)
                r=mid;
            else
                l=mid+1;
        }

        if(((long)(l)*(l+1)/2-target)%2==0)
            return l;
        if(l%2==1)
            return l+2;
        return l+1;
    }
}
