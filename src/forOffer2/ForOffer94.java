package forOffer2;

import java.util.Arrays;

public class ForOffer94 {

    public int minCut(String s) {
        boolean[][] res=getBool(s);
        int[] dp=new int[s.length()];
        for(int i=1;i<dp.length;i++){
            if(res[0][i])
                dp[i]=0;
            else{
                dp[i]=Integer.MAX_VALUE;
                for(int j=1;j<=i;j++){
                    if(res[j][i])
                        dp[i]=Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }

    private boolean[][] getBool(String s){
        boolean[][] res=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            res[i][i]=true;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                res[i][i+1]=true;
        }
        for(int l=2;l<s.length();l++){
            for(int i=0;i<s.length()-l;i++){
                if(s.charAt(i)==s.charAt(i+l)&&res[i+1][i+l-1]){
                    res[i][i+l]=true;
                }
            }
        }
        return res;
    }
}
