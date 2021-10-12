package lcp;

import java.util.Arrays;

public class lcp22 {
    /*Description
    *小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，
    * 画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色
    * （选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
    *
    * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
    * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
    * */


    public int paintingPlan(int n, int k){
        if(k==0||k==n)
            return 1;
        int[] num=new int[n+1];
        num[0]=1;
        int cur=1;
        for(int i=1;i<=n;i++){
            cur*=(n-i);
            cur/=i;
            num[i]=cur;
        }
        System.out.println(Arrays.toString(num));
        int count=0;
        for(int i=0;i<=6;i++){
            int curBlackNumber=i*n;
            if(k==curBlackNumber)
                count+=num[i];
            else if(k>=curBlackNumber&&(k-curBlackNumber)%(n-i)==0&&(k-curBlackNumber)/(n-i)<=n)
                count+=num[i]*num[(k-curBlackNumber)/(n-i)];
        }
        return count;
    }
}
