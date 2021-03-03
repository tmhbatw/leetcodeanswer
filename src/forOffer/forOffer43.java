package forOffer;

public class forOffer43 {
    /*Description
    * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
    * */

    public int countDigitOne(int n) {
        long base=1;
        int res=0;
        while(n>=base){
            int cur= (int) ((n/base)%10);
            base*=10;
            if(cur>=2)
                res+=(n/base+1)*(base/10);
            else if(cur==0)
                res+=(n/base)*(base/10);
            else{
                //System.out.println(n%(base/10));
                res+=(n/base)*(base/10)+n%(base/10)+1;
            }
            System.out.println(cur+" "+res+" "+base+" "+n);
        }
        return res;
    }
}
