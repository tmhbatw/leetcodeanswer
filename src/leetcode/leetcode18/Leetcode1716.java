package leetcode.leetcode18;

public class Leetcode1716 {

    public int totalMoney(int n) {
        int result=0;
        int base=1;
        int i=0;
        for(;i<=n-7;i+=7){
            for(int j=0;j<7;j++){
                result+=base+j;
            }
            base++;
        }
        int last=n%7;
        for(int j=0;j<last;j++){
            result+=base++;
        }
        return result;
    }
}
