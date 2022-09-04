package leetcode.leetcode24;

public class Leetcode2381 {

    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff=new int[s.length()+1];
        for(int[] shift:shifts){
            int add = shift[2]==0?-1:1;
            diff[shift[0]]+=add;
            diff[shift[1]+1]-=add;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i>=1)
                diff[i]+=diff[i-1];

            sb.append(getRes(diff[i],s.charAt(i)));
        }

        return sb.toString();
    }

    private char getRes(int cur ,char c){
        cur += c-'a';
        if(cur<0)
            cur += -(cur/26)*26+26;
        cur%=26;
        return (char)(cur+'a');
    }
}
