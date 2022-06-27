package leetcode.leetcode24;

public class Leetcode2320 {

    public int countHousePlacements(int n) {
        long result = 0;
        int mod = 1000000007;

        long pre1=0, pre2=1;
        for(int i=0;i<=n;i++){
            result = (pre1+pre2)%mod;
            pre1=pre2%mod;
            pre2=result;
        }

        return (int)(result*result%mod);
    }

    public static void main(String[] args){
        System.out.println(new Leetcode2320().countHousePlacements(1000));
    }
}
