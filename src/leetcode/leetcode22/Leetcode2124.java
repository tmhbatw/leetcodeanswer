package leetcode.leetcode22;

public class Leetcode2124 {

    public boolean checkString(String s) {
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1))
                return false;
        }
        return true;
    }

}
