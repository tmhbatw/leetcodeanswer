package forOffer2;

public class ForOffer96 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s3.charAt(i)&&dp[i][0])
                dp[i+1][0]=true;
        }
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==s3.charAt(i)&&dp[0][i])
                dp[0][i+1]=true;
        }
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s2.charAt(j)==s3.charAt(i+1+j)&&dp[i+1][j]||
                        s1.charAt(i)==s3.charAt(j+1+i)&&dp[i][j+1])
                    dp[i+1][j+1]=true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
