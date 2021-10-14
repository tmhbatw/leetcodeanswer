package leetcode.leetcode9;

public class Leetcode868 {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        int res=0;
        int pre=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1') {
                res = Math.max(i - pre, res);
                pre=i;
            }
        }
        return res;
    }
}
