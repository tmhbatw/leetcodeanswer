package leetcode6;

public class Leetcode504 {
    /*Description
    * 给定一个整数，将其转化为7进制，并以字符串形式输出。
    * */

    public String convertToBase7(int num) {
        if(num==0)
            return "0";
        boolean positive=true;
        if(num<=0){
            positive=false;
            num=-num;
        }
        StringBuilder sb=new StringBuilder();
        while(num>0){
            int mod=num%7;
            sb.append(mod);
            num/=7;
        }
        if(!positive)
            sb.append("-");
        return sb.reverse().toString();
    }
}
