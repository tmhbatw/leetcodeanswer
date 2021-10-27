package leetcode.leetcode4;

public class Leetcode357 {

    public int countNumbersWithUniqueDigits(int n) {
        n=Math.min(n,10);
        int res=0;
        for(int i=0;i<=n;i++){
            res+=getRes(i);
        }
        return res;
    }

    private int getRes(int n){
        if(n==0)
            return 1;
        int result=1;
        for(int i=1;i<=n;i++){
            result*=Math.min(9,10-i);
        }
        return result;
    }


}
