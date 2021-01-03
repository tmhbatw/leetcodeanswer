package leetcode1;

public class Leetcode91 {
    /*Description
    * 一条包含字母A-Z 的消息通过以下方式进行了编码：
    * 'A' -> 1
    * 'B' -> 2
    * ...
    * 'Z' -> 26
    * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
    * 题目数据保证答案肯定是一个 32 位的整数。
    * */

    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return 0;
        int sLength=s.length();
        int[] dp=new int[sLength+1];
        dp[1]=dp[0]=1;
        for(int i=1;i<sLength;i++){
            char cur=s.charAt(i);
            char pre=s.charAt(i-1);
            switch (pre){
                case '1':
                    if(cur!='0')
                        dp[i+1]+=dp[i];
                    dp[i+1]+=dp[i-1];
                    break;
                case '2':
                    if(cur<='6')
                        dp[i+1]+=dp[i-1];
                    if(cur!='0')
                        dp[i+1]+=dp[i];
                    break;
                default:
                    if(cur!='0')
                        dp[i+1]+=dp[i];
            }
        }
        return dp[sLength];
    }

}
