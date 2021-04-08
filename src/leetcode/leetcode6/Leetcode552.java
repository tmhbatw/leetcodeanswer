package leetcode.leetcode6;

public class Leetcode552 {
    /*Description
    * 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。
    *  答案可能非常大，你只需返回结果mod 109 + 7的值。学生出勤记录是只包含以下三个字符的字符串：
    * 'A' : Absent，缺勤
    * 'L' : Late，迟到
    * 'P' : Present，到场
    * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
    * */

    /*Solution
    * 对于A可以有1天以及1天都没有
    * */
    public int checkRecord(int n) {
        if(n==0)
            return 0;
        //先不考虑溢出的情况
        int mod=1000000007;
        long[] dp1=new long[n+1];//第i天为A且已经有A的次数
        long[] dp2=new long[n+1];//第i天为L且已经有A的次数
        long[] dp3=new long[n+1];//第i天为P且已经有A的次数
        long[] dp4=new long[n+1];//第i天为L且不含有A的次数
        long[] dp5=new long[n+1];//第i天为P且不含有A的次数
        dp1[1]=dp4[1]=dp5[1]=dp5[0]=1;
        for(int i=2;i<=n;i++){
            dp1[i]=(dp4[i-1]+dp5[i-1])%mod;
            dp2[i]=(dp1[i-1]+dp3[i-1]+dp1[i-2]+dp3[i-2])%mod;
            dp3[i]=(dp1[i-1]+dp2[i-1]+dp3[i-1])%mod;
            dp4[i]=(dp5[i-1]+dp5[i-2])%mod;
            dp5[i]=(dp4[i-1]+dp5[i-1])%mod;
        }
        return (int)((dp1[n]+dp2[n]+dp3[n]+dp4[n]+dp5[n])%mod);
    }


}
