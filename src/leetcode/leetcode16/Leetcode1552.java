package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l=1,r=position[position.length-1]-position[0];

        while(l<r){
            int mid=(l+r+1)/2;
            if(isMatch(position,mid,m))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    private boolean isMatch(int[] position,int mid,int m){
        m--;
        int pre=position[0];
        for(int cur:position){
            if(cur-pre>=mid){
                m--;
                pre=cur;
            }
        }
        return m<=0;
    }
}
