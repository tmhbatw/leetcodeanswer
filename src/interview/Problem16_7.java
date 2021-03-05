package interview;

public class Problem16_7 {
    /*Description
    * 计算机中int型整数，负数移位31为-1(
    * */

    public int maximum(int a, int b) {
        long aa=a,bb=b;

        long k=((aa-bb)>>63)+1;
        return (int) (a*k+(1-k)*b);

    }
}
