package forOffer;

import java.util.Arrays;

public class forOffer19 {
    /*Description
    * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
    * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
    * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
    * */

    public boolean isMatch(String s, String p) {
        if(s.length()==0&&p.length()==0)
            return true;
        if(p.length()==0)
            return false;
        int sLength=s.length();
        int pLength=p.length();
        boolean[][] dp=new boolean[sLength+1][pLength+1];
        dp[0][0]=true;
        for(int j=1;j<pLength;j+=2){
            if(p.charAt(j)=='*')
                dp[0][j+1]=true;
            else
                break;
        }
        for(int i=0;i<sLength;i++){
            for(int j=0;j<pLength;j++){
                if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')
                    dp[i+1][j+1]=dp[i][j];
                else if(p.charAt(j)=='*'){
                    char pre=p.charAt(j-1);
                    dp[i+1][j+1]|=dp[i+1][j-1];
                    if(pre!='.') {
                        for (int k = i; k >= 0; k--) {
                            if (s.charAt(k) != pre)
                                break;
                            dp[i+1][j+1]|=dp[k][j-1];
                        }
                    }else{
                        for(int k=i;k>=0;k--)
                            dp[i+1][j+1]|=dp[k][j-1];
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }
}
