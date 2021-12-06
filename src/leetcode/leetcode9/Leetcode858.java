package leetcode.leetcode9;

public class Leetcode858 {

    public int mirrorReflection(int p, int q) {
        int time=getRes(p,q);
        if((time/q)%2==0)
            return 2;
        return time/p%2==0?0:1;
    }

    private int getRes(int p,int q){
        return p/getGcd(p,q)*q;
    }

    private int getGcd(int p,int q){
        if(p%q==0)
            return q;
        return getGcd(q,p%q);
    }
}
