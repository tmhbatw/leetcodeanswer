package forOffer;

public class forOffer17 {
    /*Description
    * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    * */

    public int[] printNumbers(int n) {
        int number= (int) (Math.pow(10,n)-1);
        int[] res=new int[number];
        for(int i=0;i<number;i++)
            res[i]=i+1;
        return res;
    }
}
