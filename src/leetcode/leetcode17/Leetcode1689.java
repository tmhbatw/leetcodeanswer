package leetcode.leetcode17;

public class Leetcode1689 {

    public int minPartitions(String n) {
        int result=0;
        for(char cur:n.toCharArray()){
            result=Math.max(result,cur-'0');
        }
        return result;
    }
}
