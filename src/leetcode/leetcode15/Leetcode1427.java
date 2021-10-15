package leetcode.leetcode15;

public class Leetcode1427 {

    public String stringShift(String s, int[][] shift) {
        int length=s.length();
        for(int[] cur:shift){
            cur[1]%=length;
            if(cur[0]==1)
                cur[1]=length-cur[1];
            s=s.substring(cur[1])+s.substring(0,cur[1]);
        }
        return s;
    }
}
