package leetcode.leetcode12;

public class Leetcode1134 {
    public boolean isArmstrong(int n) {
        int k=(n+"").length();
        int res=0;
        int num=n;
        while(num>0){
            int last=num%10;
            num/=10;
            res+=Math.pow(last,k);
        }
        return res==n;
    }
}
