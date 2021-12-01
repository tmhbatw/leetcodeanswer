package leetcode.leetcode13;

public class Leetcode1256 {

    public String encode(int num) {
        String res=Integer.toBinaryString(num+1);
        return res.substring(1);
    }
}
