package leetcode.leetcode5;

public class Leetcode424 {

    public int characterReplacement(String s, int k) {
        int result=0;
        for(int i=0;i<26;i++){
            result=Math.max(result,characterReplacement(s,k,(char)(i+'A')));
        }
        return result;
    }

    private int characterReplacement(String s, int k, char cur){
        int length=s.length();
        int result=0;
        int j=0;
        for(int i=0;i<length;i++){
            while(j<length&&k-(s.charAt(j)==cur?0:1)>=0) {
                k-=(s.charAt(j++)==cur?0:1);
            }
            result=Math.max(result,j-i);
            if(s.charAt(i)!=cur)
                k++;
        }
        return result;
    }
}
