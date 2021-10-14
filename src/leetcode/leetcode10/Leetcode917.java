package leetcode.leetcode10;

public class Leetcode917 {

    public String reverseOnlyLetters(String s) {
        char[] c=s.toCharArray();
        int l=0,r=c.length-1;
        while(l<r){
            if(!isLetter(s.charAt(l)))
                l++;
            else if(!isLetter(s.charAt(r)))
                r--;
            else{
                char temp=c[l];
                c[l++]=c[r];
                c[r--]=temp;
            }
        }
        return new String(c);
    }

    private boolean isLetter(char c){
        return c<='Z'&&c>='A'||c<='z'&&c>='a';
    }
}
