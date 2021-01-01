package leetcode1;

import java.util.Arrays;

public class Leetcode44 {
    /*Description
    * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
    * '?' 可以匹配任何单个字符。
    * '*' 可以匹配任意字符串（包括空字符串）。
    * 两个字符串完全匹配才算匹配成功。
    * 说明:
    * s可能为空，且只包含从a-z的小写字母。
    * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
    * */

    /*使用动态规划方法试一试
    * */
    public boolean isMatch(String s, String p) {
        StringBuilder pp=new StringBuilder();
        int length=p.length();
        for(int i=0;i<length;i++){
            char cur=p.charAt(i);
            if(cur=='*'){
                while(i<length-1&&p.charAt(i+1)==cur)
                    i++;
            }
            pp.append(cur);
        }
        int sLength=s.length(),pLength=pp.length();
        boolean[][] dp=new boolean[pLength+1][sLength+1];
        dp[0][0]=true;
        for(int i=0;i<pLength;i++){
            char curP=pp.charAt(i);
            if(curP=='*')
                dp[i+1][0]=dp[i][0];
            for(int j=0;j<sLength;j++){
                char curS=s.charAt(j);
                if (curP == curS || curP=='?'){
                    dp[i+1][j+1]=dp[i][j];
                }
                if(curP=='*')
                    dp[i+1][j+1]=dp[i][j+1]||dp[i+1][j];
            }
        }
        return dp[pLength][sLength];
    }

    //暴力递归方法，进行了部分时间优化，但是最后仍然超时
/*
    public boolean isMatch(String s, String p) {
        return isMatched(s,p,0,0);
    }

    private boolean isMatched(String s,String p,int i,int j){
        if(i==s.length()&&j==p.length())
            return true;
        if(i>s.length()||j>=p.length())
            return false;
        char curP=p.charAt(j);
        switch (curP){
            case '?':
                return isMatched(s,p,i+1,j+1);
            case '*':
                while(j<p.length()-1&&p.charAt(j+1)=='*')
                    j++;
                if(j==p.length()-1)
                    return true;
                char next=p.charAt(j+1);
                if(next=='?') {
                    for (int k = i; k <= s.length(); k++) {
                        if (isMatched(s, p, k, j + 1))
                            return true;
                    }
                    return false;
                }
                for(int k=i;k<s.length();k++){
                    if(s.charAt(k)==next&&isMatched(s,p,k+1,j+2))
                        return true;
                }
                return false;
            default:
                if(i==s.length()||s.charAt(i)!=p.charAt(j))
                    return false;
                return isMatched(s,p,i+1,j+1);
        }
    }
*/

    public static void main(String[] args){
        System.out.println(new Leetcode44().isMatch("aa","*"));
/*        System.out.println(new Leetcode44().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbab" +
                        "ababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababa" +
                        "babbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*" +
                        "ba*bb*bb**a*b*bb"));*/
    }
}
