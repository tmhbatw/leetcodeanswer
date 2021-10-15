package leetcode.leetcode14;

public class Leetcode1317 {

    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n/2;i++){
            if(isNoZero(i)&&(isNoZero(n-i)))
                return new int[]{i,n-i};
        }
        return null;
    }

    private boolean isNoZero(int cur){
        while(cur>0){
            int last=cur%10;
            if(last==0)
                return false;
            cur/=10;
        }
        return true;
    }
}
