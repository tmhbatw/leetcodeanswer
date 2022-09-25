package leetcode.leetcode23;

public class Leetcode2217 {

    boolean small;
    public long[] kthPalindrome(int[] queries, int intLength) {
        this.small = intLength%2==1;
        long start=1;
        for(int i=0;i<(intLength-1)/2;i++){
            start*=10;
        }

        long[] result=new long[queries.length];
        for(int i=0;i<queries.length;i++){
            long cur = start+queries[i]-1;
            if(cur>=start*10)
                result[i]=-1;
            else
                result[i]=getRes(start+queries[i]-1);
        }
        return result;
    }

    private long getRes(long cur){
        long left=cur;
        if(small){
            left/=10;
        }
        while(left>0) {
            cur = cur * 10 + (left % 10);
            left/=10;
        }
        return cur;
    }

}
