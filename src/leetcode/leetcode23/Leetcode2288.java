package leetcode.leetcode23;

import java.text.DecimalFormat;
import java.text.Format;

public class Leetcode2288 {

    DecimalFormat df = new DecimalFormat(".00");

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb=new StringBuilder();
        for(String cur:sentence.split(" ")){
            if(isDollar(cur))
                sb.append(" ").append(reverse(cur,discount));
            else
                sb.append(" ").append(cur);
        }

        return sb.substring(1);
    }

    private boolean isDollar(String cur){
        if(cur.length()>11||cur.length()<2)
            return false;
        if(cur.charAt(0)!='$')
            return false;

        for(int i=1;i<cur.length();i++){
            if(cur.charAt(i)>'9'||cur.charAt(i)<'0')
                return false;
        }
        return true;
    }

    private String reverse(String cur,int discount){
        double d = Double.parseDouble(cur.substring(1));
        d = d*(100-discount);

        return "$"+df.format(d);
    }

    public static void main(String[] args){
        double cur = 0.305;

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(cur));
        System.out.println(cur);
    }
}
