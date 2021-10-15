package forOffer2;

public class ForOffer01 {

    public int divide(int dividend, int divisor) {
        boolean positive=true;

        if(dividend<0){
            if(dividend==Integer.MIN_VALUE){
                if(divisor==dividend)
                    return 1;
                if(divisor==-1)
                    return Integer.MAX_VALUE;
                return divisor>0?-1+divide(dividend+divisor,divisor):
                        1+divide(dividend-divisor,divisor);
            }
            dividend=-dividend;
            positive= false;
        }
        if(divisor<0){
            if(divisor==Integer.MIN_VALUE)
                return 0;
            divisor=-divisor;
            positive= !positive;
        }
        int length=Integer.toBinaryString(divisor).length();
        int result=0;
        for(int i=31-length;i>=0;i--){
            int curDivisor=divisor<<i;
            if(dividend>=curDivisor){
                result+=(1<<i);
                dividend-=curDivisor;
            }
        }
        return positive?result:-result;
    }
}
