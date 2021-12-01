package leetcode.leetcode12;

import java.util.Arrays;

public class Leetcode1101 {

    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(weights,days,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean isMatch(int[] weights,int days,int mid){
        int cur=0;
        int count=0;
        for(int num:weights){
            if(num>mid)
                return false;
            if(cur+num>mid){
                count++;
                cur=num;
            }else
                cur+=num;
        }
        return count+1<=days;
    }

    public int earliestAcq(int[][] logs, int n) {
        int[] type=new int[n];
        init(type);

        int num=n;
        Arrays.sort(logs,(o1,o2)->{
            return o1[0]-o2[0];
        });

        for(int[] log:logs){
            int t1=getType(type,log[1]);
            int t2=getType(type,log[2]);
            if(t1==t2)
                continue;

            type[t2]=t1;
            num--;
            if(num==1)
                return log[0];
        }
        return -1;
    }

    private int getType(int[] type,int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }

    private void init(int[] num){
        for(int i=0;i<num.length;i++)
            num[i]=i;
    }
}
