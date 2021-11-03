package leetcode.leetcode19;

public class Leetcode1823 {

    public int findTheWinner(int n, int k) {
        int index=0;
        for(int i=2;i<=n;i++){
            index=(index+k)%i;
        }
        return index+1;
    }
}
