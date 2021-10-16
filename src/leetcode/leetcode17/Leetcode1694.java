package leetcode.leetcode17;

public class Leetcode1694 {

    public String reformatNumber(String number) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)<='9'&&number.charAt(i)>='0')
                sb.append(number.charAt(i));
        }
        int i=0;
        StringBuilder result=new StringBuilder();
        for(;i<sb.length()-4;i+=3){
            result.append(sb.substring(i,i+3)).append("-");
        }
        if(sb.length()-i==4){
            result.append(sb.substring(i,i+2)).append("-");
            i+=2;
        }
        result.append(sb.substring(i));
        return result.toString();
    }
}
