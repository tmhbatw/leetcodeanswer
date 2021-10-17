package leetcode.leetcode21;

public class Leetcode2027 {
    public int minimumMoves(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='X') {
                i += 2;
                res++;
            }
        }
        return res;
    }
}
