package leetcode.leetcode13;

public class Leetcode1281 {
    public int subtractProductAndSum(int n) {
        char[] c=(n+"").toCharArray();
        int val1=1;
        int val2=0;
        for(char cur:c){
            val1*=(cur-'0');
            val2+=(cur-'0');
        }
        return val1-val2;
    }
}
