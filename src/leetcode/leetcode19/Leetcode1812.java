package leetcode.leetcode19;

public class Leetcode1812 {
    public boolean squareIsWhite(String coordinates) {
        int val1=coordinates.charAt(0)-'a';
        int val2=coordinates.charAt(1)-'1';
        if(val1%2==val2%2)
            return false;
        return true;
    }
}
