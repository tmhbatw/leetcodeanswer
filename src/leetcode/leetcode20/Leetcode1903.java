package leetcode.leetcode20;

public class Leetcode1903 {

    public String largestOddNumber(String num) {
        int index=num.length()-1;
        for(;index>=0;index--){
            if((num.charAt(index)-'0')%2==1)
                break;
        }
        return num.substring(0,index+1);
    }
}
