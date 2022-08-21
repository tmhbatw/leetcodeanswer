package leetcode.leetcode17;

public class Leetcode1680 {

    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long cur=0;
        int base=1;
        int count = 0;
        int digit=1;
        for(int i=1;i<=n;i++){
            cur <<= digit;
            cur+=i;
            count++;
            if(count==base){
                count=0;
                base*=2;
                digit++;
            }
            cur%=mod;
        }
        return (int)cur;
    }

}
