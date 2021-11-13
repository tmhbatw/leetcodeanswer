package leetcode.leetcode9;

import java.util.Arrays;
import java.util.Locale;

public class Leetcode869 {

    public boolean reorderedPowerOf2(int n) {
        int length=getLength(n);
        int base=1;
        while(getLength(base)<length)
            base*=2;

        String num=getNum(n);
        while(getLength(base)==length){
            String cur=getNum(base);
            if(cur.equals(num))
                return true;
            base*=2;
        }
        return false;
    }

    private int getLength(int n){
        return (n+"").length();
    }

    private String getNum(int n){
        char[] num=(n+"").toCharArray();
        Arrays.sort(num);
        return new String(num);
    }
}
