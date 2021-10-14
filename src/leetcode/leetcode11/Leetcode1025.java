package leetcode.leetcode11;

public class Leetcode1025 {

    boolean[] reached=new boolean[1001];
    boolean[] res=new boolean[1001];
    public boolean divisorGame(int n) {
        if(n==1)
            return false;
        if(reached[n])
            return res[n];
        for(int i=1;i<n;i++){
            if(n%i==0&&!divisorGame(n-i)) {
                reached[n]=true;
                res[n]=true;
                return true;
            }
        }
        reached[n]=true;
        return false;
    }
}
