package interview;

public class Problem5_6 {
    /*Description
    * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
    * */

    public int convertInteger(int A, int B) {
        int res=0;
        for(int i=0;i<32;i++){
            if((A>>i&1)!=(B>>i&1))
                res++;
        }
        return res;
    }
}
