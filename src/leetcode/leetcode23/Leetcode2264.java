package leetcode.leetcode23;

public class Leetcode2264 {

    public String largestGoodInteger(String num) {
        char result = '\u0000';
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1)&&num.charAt(i)==num.charAt(i+2))
                result = (char) Math.max(result,num.charAt(i));
        }

        if(result =='\u0000')
            return "";
        return ""+result+result+result;
    }
}
