package leetcode.leetcode25;

public class Leetcode2411 {

    public int[] smallestSubarrays(int[] nums) {
        int[] max=new int[32];
        for(int num:nums)
            add(max,num);
        int j=0;
        int[] cur=new int[32];
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(getRes(cur)<getRes(max)&&j<nums.length){
                add(cur,nums[j++]);
            }
            res[i]=Math.max(1,j-i);
            del(cur,nums[i]);
            del(max,nums[i]);
        }
        return res;
    }

    private void del(int[] cur,int num){
        int[] n=getRes(num);
        for(int i=0;i<32;i++){
            cur[i]-=n[i];
        }
    }

    private void add(int[] cur,int num){
        int[] n=getRes(num);
        for(int i=0;i<32;i++){
            cur[i]+=n[i];
        }
    }

    private int getRes(int[] cur){
        int result=0;
        for(int i=0;i<32;i++){
            if(cur[i]>0){
                result+=(1<<i);
            }
        }
        return result;
    }

    private int[] getRes(int cur){
        int[] time=new int[32];
        int index=0;
        while(cur>0){
            if(cur%2==0)
                time[index++]=0;
            else
                time[index++]=1;
            cur/=2;
        }
        return time;
    }




}
