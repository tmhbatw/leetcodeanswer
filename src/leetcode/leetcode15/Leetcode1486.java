package leetcode.leetcode15;

public class Leetcode1486 {

    public int xorOperation(int n, int start) {
        int cur=0;
        for(int i=0;i<n;i++)
            cur^=(i*2+start);
        return cur;
    }
}
