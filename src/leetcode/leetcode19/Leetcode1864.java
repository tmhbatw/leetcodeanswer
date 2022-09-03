package leetcode.leetcode19;

public class Leetcode1864 {

    public int minSwaps(String s) {
        int zero =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                zero++;
        }
        int one=s.length()-zero;

        if(Math.abs(one-zero)>1)
            return -1;
        if(one>zero)
            return getRes(s, '1');
        if(one<zero)
            return getRes(s,'0');
        return Math.min(getRes(s,'1'),getRes(s,'0'));
    }

    private int getRes(String s, char cur){
        int diff=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=cur&&s.charAt(i)=='0')
                diff++;
            cur = cur=='0'?'1':'0';
        }
        return diff;
    }


}
