package leetcode.leetcode11;

public class Leetcode1009 {

    public int bitwiseComplement(int n) {
        char[] c=Integer.toBinaryString(n).toCharArray();
        int result=0;
        int base=1;
        for(int i=c.length-1;i>=0;i--) {
            if (c[i] == '0')
                result += base;
            base *= 2;
        }
        return result;
    }
}
