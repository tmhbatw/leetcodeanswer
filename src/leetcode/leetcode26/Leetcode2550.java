package leetcode.leetcode26;

public class Leetcode2550 {
    int mod = 1000000007;

    public int monkeyMove(int n) {
        long result = 1;
        long cur = 2;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= cur;
            }
            n /= 2;
            cur *= cur;
            cur %= mod;
            result %= mod;
        }

        return (int) (result + mod - 2) % mod;
    }

}
