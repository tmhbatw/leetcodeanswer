package leetcode.leetcode22;

public class Leetcode2138 {
    public String[] divideString(String s, int k, char fill) {
        int length=(s.length()-1)/k+1;
        String[] result=new String[length];

        for(int i=s.length();i<length*k;i++)
            s=s+fill;

        for(int i=0;i<result.length;i++)
            result[i]=s.substring(i*k,(i+1)*k);

        return result;
    }
}
