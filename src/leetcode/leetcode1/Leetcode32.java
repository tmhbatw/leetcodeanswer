package leetcode.leetcode1;

public class Leetcode32 {
    /*Description
    *给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    * */

    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0)
            return 0;
        int result=0;
        //dp[i]用来存储最后一项为第i项的匹配字符串的长度；
        int[] dp=new int[s.length()+1];
        dp[1]=0;
        for(int i=1;i<s.length();i++){
            //如果当前字符为'（'则可以直接置为0
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i+1]=2+dp[i-1];
                }else{
                    int preIndex=i-dp[i]-1;
                    if(preIndex>=0&&s.charAt(preIndex)=='(')
                        dp[i+1]=2+dp[i]+dp[preIndex];
                }
            }
            result=Math.max(result,dp[i+1]);
        }
        return result;
    }
    //O(n3次方方法超时）
/*    public int longestValidParentheses(String s) {
        int sLength=s.length();
        boolean[][] dp=new boolean[sLength][sLength];
        int result=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='('&&s.charAt(i+1)==')') {
                dp[i][i + 1] = true;
                result=2;
            }
        }
        for(int length=3;length<sLength;length+=2){
            for(int i=0;i<sLength-length;i++){
                if(s.charAt(i)=='('&&s.charAt(i+length)==')'&&dp[i+1][i+length-1]){
                    result=length+1;
                    dp[i][i+length]=true;
                    continue;
                }
                for(int j=i+1;j<i+length;j+=2){
                    if(dp[i][j]&&dp[j+1][i+length]){
                        result=length+1;
                        dp[i][i+length]=true;
                    }
                }
            }
        }
        return result;
    }*/
}
