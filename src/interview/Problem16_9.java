package interview;

import java.util.Arrays;

public class Problem16_9 {
    /*Description
    * 请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，
    * 程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。
    * 你的实现应该支持如下操作：
    * Operations() 构造函数
    * minus(a, b) 减法，返回a - b
    * multiply(a, b) 乘法，返回a * b
    * divide(a, b) 除法，返回a / b
    * */

    static class Operations {

        long[] positive;
        long[] negative;
        public Operations() {
            positive=new long[32];
            positive[0]=1;
            negative=new long[32];
            negative[0]=-1;
            for(int i=1;i<32;i++) {
                positive[i] = positive[i - 1] + positive[i - 1];
                negative[i] = negative[i - 1] + negative[i - 1];
            }
        }

        public int minus(int a, int b) {
            return (int)(a+getOpposite(b));
        }

        public int multiply(int a, int b) {
            long aa=a;long bb=b;
            if(bb<0){
                aa=getOpposite(a);
                bb=getOpposite(b);
            }
            if(bb==0)
                return 0;
            boolean[] dp=new boolean[32];
            for(int i=31;i>=0;i--){
                if(bb>=positive[i]){
                    dp[i]=true;
                    bb-=positive[i];
                }
            }
            long result=0;
            for(int i=0;i<32;i++){
                if(dp[i]){
                    result+=aa;
                }
                aa=aa+aa;
            }
            return (int)result;
        }

        public int divide(int a, int b) {
            if(a==0)
                return 0;
            boolean positive=a>0&&b<0||a<0&&b>0;
            long aa=a;long bb=b;
            if(aa<0)
                aa=getOpposite(a);
            if(bb<0)
                bb=getOpposite(b);
            long[] dp=new long[32];
            dp[0]=bb;
            int index=1;
            for(;index<32;index++){
                dp[index]=dp[index-1]+dp[index-1];
                if(dp[index]<0){
                    index--;
                    break;
                }
                if(index==31)
                    break;
            }
            long res=0;
            for(;index>=0;index--){
                if(aa>=dp[index]){
                    res+=this.positive[index];
                    aa-=dp[index];
                }
            }
            return (int)(positive?-res:res);
        }

        private long getOpposite(int cur){
            long result=0;
            if(cur>0){
                for(int i=31;i>=0;i--){
                    if(cur+negative[i]>=0){
                        result+=negative[i];
                        cur+=negative[i];
                    }
                }
            }else{
                for(int i=31;i>=0;i--){
                    if(cur+positive[i]<=0){
                        result+=positive[i];
                        cur+=positive[i];
                    }
                }
            }
            return result;
        }
    }



    public static void main(String[] args){
        System.out.println(1233333333+1233333333);
        Operations o=new Operations();
        for(int i=-10000;i<=10000;i++){
            if(o.getOpposite(i)!=-i) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);

    }
}
