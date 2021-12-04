package leetcode.leetcode11;

public class Leetcode1017 {

    public String baseNeg2(int n) {
        if(n==0)
            return "0";
        boolean positive=true;

        StringBuilder sb=new StringBuilder();
        while(n>0){
            if(n%2==1){
                if (!positive) {
                    n++;
                }
                sb.append("1");
            }else
                sb.append('0');
            positive=!positive;
            n/=2;
        }
        return sb.reverse().toString();
    }
}
