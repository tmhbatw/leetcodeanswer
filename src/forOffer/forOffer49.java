package forOffer;

public class forOffer49 {
    /*Description
    * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * */

    public int nthUglyNumber(int n) {
        int num2=2,num3=3,num5=5;
        int[] dp=new int[n];
        dp[0]=1;
        int index2=1,index3=1,index5=1;
        for(int i=1;i<n;i++){
            if(num2<=num3&&num2<=num5){
                dp[i]=num2;
                num2=dp[index2++]*2;
                if(num3==dp[i])
                    num3=3*dp[index3++];
                if(num5==dp[i])
                    num5=5*dp[index5++];
            }
            else if(num3<num2&&num3<=num5){
                dp[i]=num3;
                num3=dp[index3++]*3;
                if(num5==dp[i])
                    num5=dp[index5++]*5;
            }
            else{
                dp[i]=num5;
                num5=dp[index5++]*5;
            }
            System.out.println(dp[i]+" "+num2+" "+num3+" "+num5);
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        System.out.println(new forOffer49().nthUglyNumber(1600));
    }
}
