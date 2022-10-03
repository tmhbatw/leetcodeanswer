package leetcode.leetcode19;

public class Leetcode1888 {

    public int minFlips(String s) {
        int min=Math.min(getCount(s,'0'),getCount(s,'1'));
        s=s.substring(1)+s.charAt(0);
        int min2=Math.min(getCount(s,'0'),getCount(s,'1'));
        s=s.substring(1)+s.charAt(0);
        int min3=Math.min(getCount(s,'0'),getCount(s,'1'));
        min=Math.min(min,min3);
        return Math.min(min,min2);
    }

    private int getCount(String s, char cur){
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=cur)
                count++;
            cur = cur=='0'?'1':'0';
        }
        return count;
    }


}
