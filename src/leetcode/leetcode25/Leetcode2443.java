package leetcode.leetcode25;

public class Leetcode2443 {

    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            if(i+reverse(i)==num)
                return true;
        }
        return false;
    }

    private int reverse(int num){
        int cur=0;
        while(num>0){
            cur=cur*10+num%10;
            num/=10;
        }
        return cur;
    }


}
