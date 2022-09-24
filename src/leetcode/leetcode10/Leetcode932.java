package leetcode.leetcode10;

public class Leetcode932 {

    //可以将n个数分为1，3，5...和2，4，6...
    public int[] beautifulArray(int n) {
        if(n==1)
            return new int[]{1};
        int[] res=beautifulArray((n+1)/2);
        int[] result=new int[n];
        int j=(n+1)/2;
        for(int i=0;i<res.length;i++){
            result[i]=res[i]*2-1;
            if(res[i]*2<=n)
                result[j++]=res[i]*2;
        }
        return result;
    }


}
