package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2300 {

    public static void main(String[] args){
        System.out.println("hello world");
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result =new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            result[i] = getRes(spells[i],potions,success);
        }
        return result;
    }

    private int getRes(int cur,int[] potions,long success){
        long c=cur;
        if(c*potions[potions.length-1]<success)
            return 0;

        int l=0,r=potions.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(c*potions[mid]>=success)
                r=mid;
            else
                l = mid+1;
        }
        return potions.length-l;
    }

}
