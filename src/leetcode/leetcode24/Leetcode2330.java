package leetcode.leetcode24;

public class Leetcode2330 {

    public boolean makePalindrome(String s) {
        int count =0 ;
        int length=s.length();
        for(int i=0;i<length/2;i++){
            if(s.charAt(i)!=s.charAt(length-i-1))
                count++;
        }

        return count==2||count==1||count==0;
    }


}
