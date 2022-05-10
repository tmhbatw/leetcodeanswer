package leetcode.leetcode23;

public class Leetcode2266 {

    public int countTexts(String pressedKeys) {
        int[] number = new int[]{0,0,3,3,3,3,3,4,3,4};
        int[] dp=new int[pressedKeys.length()+1];
        dp[0]=1;
        int mod = 1000000007;

        for(int i=0;i<pressedKeys.length();i++){
            int time = number[pressedKeys.charAt(i)-'0'];
            int real = i;
            while(real<pressedKeys.length()-1
                    &&pressedKeys.charAt(real+1)==pressedKeys.charAt(i)
                    &&real-i<time-1){
                real++;
            }
            for(int j=i;j<=real;j++){
                dp[j+1] = (dp[j+1]+dp[i])%mod;
            }
        }
        return dp[pressedKeys.length()];
    }
}
