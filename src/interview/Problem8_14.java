package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem8_14 {
    /*Description
    * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
    * 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
    * */

    public int countEval(String s, int result) {
        int time=s.length()/2+1;
        int[][] dp0=new int[time][time];//其中dp[i][j]表示从第i个数到第j个数的为0的结果数量
        int[][] dp1=new int[time][time];//同上，但是结果为1
        for(int i=0;i<time;i++){
            if(s.charAt(i*2)=='0'){
                dp0[i][i]=1;
            }else{
                dp1[i][i]=1;
            }
        }
        for(int length=1;length<time;length++){
            for(int i=0;i<time-length;i++){
                int j=i+length;
                for(int l=i+1;l<=j;l++){
                    char cur=s.charAt(2*l-1);
                    if(cur=='|') {
                        dp1[i][j] += dp0[i][l - 1] * dp1[l][j] + dp1[i][l - 1] * (dp0[l][j] + dp1[l][j]);
                        dp0[i][j]+=dp0[i][l-1]*dp0[l][j];
                    }else if(cur=='&'){
                        dp0[i][j]+=dp0[i][l-1]*(dp0[l][j] + dp1[l][j])+dp1[i][l-1]*dp0[l][j];
                        dp1[i][j]+=dp1[i][l-1]*dp1[l][j];
                    }else{
                        dp1[i][j]+=dp0[i][l-1]*dp1[l][j]+dp1[i][l-1]*dp0[l][j];
                        dp0[i][j]+=dp0[i][l-1]*dp0[l][j]+dp1[i][l-1]*dp1[l][j];
                    }
                }
            }
        }

        if(result==0)
            return dp0[0][time-1];
        return dp1[0][time-1];
    }
}
