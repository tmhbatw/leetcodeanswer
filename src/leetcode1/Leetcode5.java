package leetcode1;

public class Leetcode5 {
    /*Description
    * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    * */

    public String longestPalindrome(String s) {
        int res=0;
        int curMaxLength=1;
        int sLength=s.length();
        boolean[][] dp=new boolean[sLength][sLength];
        for(int i=0;i<sLength;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<sLength-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) {
                if(curMaxLength<2) {
                    curMaxLength = 2;
                    res = i;
                }
                dp[i][i + 1] = true;
            }
        }
        for(int length=2;length<s.length();length++){
            for(int i=0;i<sLength-length;i++){
                int j=i+length;
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(curMaxLength<length+1) {
                        curMaxLength = length + 1;
                        res = i;
                    }
                }
            }
        }
        return s.substring(res,res+curMaxLength);
    }
}
