package leetcode.leetcode9;

import java.util.Arrays;

public class Leetcode881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1;
        int result=0;
        while(l<=r){
            if(l==r)
                return result+1;
            if(people[l]+people[r]>limit){
                result++;
                r--;
            }else{
                result++;
                l++;
                r--;
            }
        }
        return result;
    }
}
