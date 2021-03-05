package interview;

public class Problem5_3 {
    /*Description
    * 给定一个32位整数 num，你可以将一个数位从0变为1。
    * 请编写一个程序，找出你能够获得的最长的一串1的长度。
    * */

    public int reverseBits(int num) {
        int result=0;
        for(int i=0;i<32;i++){
            if((num>>i&1)==1){
                int pre=0;
                for(int j=i-1;j>=0;j--){
                    if((num>>j&1)==1)
                        pre++;
                    else break;
                }
                int last=0;
                for(int j=i+1;j<32;j++){
                    if((num>>j&1)==1)
                        last++;
                    else
                        break;
                }
            }
        }
        return result==0?32:result;
    }
}
