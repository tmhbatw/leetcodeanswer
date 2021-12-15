package leetcode.leetcode21;

import java.util.SortedSet;

public class Leetcode2031 {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n=nums.length;
        FenwickTree tree= new FenwickTree(n);

        int res=0;
        int sum=0;
        tree.add(0);
        int mod=1000000007;

        for(int i:nums){
            sum += i==0?-1:1;
            tree.add(sum);
            res=(res+tree.getPre(sum-1))%mod;
        }
        return res;
    }

    static class FenwickTree{
        int[] num;
        int n;
        public FenwickTree(int n){
            this.n=n;
            this.num=new int[n*2+2];
        }

        private void add(int x){
            x += n+1;
            while(x<num.length){
                this.num[x]++;
                x+=lowbit(x);
            }
        }

        private int getPre(int x){
            x += n+1;
            int res=0;
            while(x>0){
                res+=this.num[x];
                x-=lowbit(x);
            }
            return res;
        }

        private int lowbit(int x){
            return x&(-x);
        }
    }
}
