package leetcode.leetcode20;

public class Leetcode1925 {

    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<n;j++){
                int cur=i*i+j*j;
                int sqrt= (int) Math.sqrt(cur);
                if(sqrt<=n&&sqrt*sqrt==cur)
                    count++;
            }
        }
        return count;
    }
}
