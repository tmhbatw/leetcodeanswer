package leetcode.leetcode18;

public class Leetcode1750 {

    public int minimumLength(String s) {
        int i=0,j=s.length()-1;
        while(i<j&&s.charAt(i)==s.charAt(j)){
            while(i<s.length()-1&&s.charAt(i+1)==s.charAt(i)){
                i++;
            }
            while(j>=1&&s.charAt(j-1)==s.charAt(j)){
                j--;
            }

            if(i>=j){
                return 0;
            }

            i++;
            j--;
        }

        return j-i+1;
    }

}
