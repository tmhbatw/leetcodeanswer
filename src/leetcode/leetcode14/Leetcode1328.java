package leetcode.leetcode14;

public class Leetcode1328 {

    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";
        char[] c=palindrome.toCharArray();
        for(int i=0;i<c.length/2;i++){
            if(c[i]>'a'){
                c[i]='a';
                return new String(c);
            }
        }

        c[c.length-1]='b';
        return new String(c);
    }

}
