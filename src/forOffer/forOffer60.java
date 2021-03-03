package forOffer;

import java.util.Arrays;

public class forOffer60 {
    /*Description
    * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
    * */

    public double[] dicesProbability(int n) {
        double[][] res=new double[n+1][n*6+1];
        res[1][1]=res[1][2]=res[1][3]=res[1][4]=res[1][5]=res[1][6]=1.0/6;
        for(int i=2;i<=n;i++){
            for(int j=i;j<=i*6;j++){
                for(int k=1;k<=Math.min(6,j-1);k++){
                    res[i][j]+=res[i-1][j-k]*(1.0/6);
                }
            }
        }
        double[] result=new double[1+5*n];
        for(int i=n;i<=6*n;i++)
            result[i-n]=res[n][i];
        return result;
    }
}
