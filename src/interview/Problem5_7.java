package interview;

public class Problem5_7 {
    /*Description
    * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（
    * 也就是说，位0与位1交换，位2与位3交换，以此类推）。
     * */

    public int exchangeBits(int num) {
        int base=3;
        for(int i=0;i<32;i+=2){
            System.out.println((num>>i&1)+"  "+(num>>(i+1)&1));
            if(((num>>i)&1)!=((num>>(i+1))&1)) {
                num ^= base;
                System.out.println(num);
            }
            base<<=2;
        }
        return num;
    }
}
