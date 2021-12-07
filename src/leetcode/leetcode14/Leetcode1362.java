package leetcode.leetcode14;

public class Leetcode1362 {

    public int[] closestDivisors(int num) {
        int[] res1=getRes(num+1);
        int[] res2=getRes(num+2);
        if(res1[1]-res1[0]<res2[1]-res2[0])
            return res1;
        return res2;
    }

    private int[] getRes(int num){
        for(int i = (int) Math.sqrt(num); i>=1; i--){
            if(num%i==0)
                return new int[]{i,num/i};
        }
        return new int[]{0,0};
    }
}
