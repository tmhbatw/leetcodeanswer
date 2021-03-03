package forOffer;

public class forOffer44 {
    /*Description
    *数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
    * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    * 请写一个函数，求任意第n位对应的数字。
    * */

    public int findNthDigit(int n) {
        int numLength=1;
        int cur=1;
        while(n>0){
            if(n>(cur* 10L -cur)*numLength){
                n-=(cur*10-cur)*numLength;
                cur*=10;
                numLength++;
            }else{
                int left=n%numLength;
                cur+=n/numLength-1;
                if(left==0)
                    return cur%10;
                return String.valueOf(cur+1).charAt(left-1)-'0';
            }
        }
        return -1;
    }
}
