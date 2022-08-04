package leetcode.leetcode17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Leetcode1648 {

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);

        long result=0;
        int mod=1000000007;
        for(int j=inventory.length-1;j>=0;j--){
            int max=inventory[j];
            while(j>=1&&inventory[j-1]==max){
                j--;
            }
            long cur=inventory.length-j;
            long pre=j==0?0:inventory[j-1];

            if(cur*(max-pre)<=(long)orders){
                orders-=cur*(max-pre);
                result+=cur*(max+pre+1)*(max-pre)/2;
                result%=mod;
            }else{
                long maxTime=  ((long)orders/cur);
                result+=cur*(max+max-maxTime+1)*maxTime/2;
                result+=((long)orders%cur)*(max-maxTime);
                result%=mod;
                return (int)result;
            }
            //System.out.println(result+" "+orders);
        }

        return (int) result;
    }
    public static void main(String[] args){
        int[] t=new int[]{2,4,6,8,10};
        System.out.println(new Leetcode1648().maxProfit(t,20));
    }
}
