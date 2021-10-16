package leetcode.leetcode18;

public class Leetcode1720 {

    public int[] decode(int[] encoded, int first) {
        int[] res=new int[encoded.length];
        res[0]=first;
        for(int i=1;i<res.length;i++)
            res[i]=res[i-1]^encoded[i-1];
        return res;
    }
}
