package leetcode.leetcode19;

public class Leetcode1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a=0,b=0,c=0;
        for(int[] t:triplets){
            if(t[0]<=target[0]&&t[1]<=target[1]&&t[2]<=target[2]){
                a=Math.max(t[0],a);
                b=Math.max(t[1],b);
                c=Math.max(t[2],c);
            }
        }
        return a==target[0]&&b==target[1]&&c==target[2];
    }
}
