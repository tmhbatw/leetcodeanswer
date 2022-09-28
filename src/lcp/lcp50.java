package lcp;

public class lcp50 {

    public int giveGem(int[] gem, int[][] operations) {
        for(int[] o:operations){
            int temp = gem[o[0]]/2;
            gem[o[0]]-=temp;
            gem[o[1]]+=temp;
        }

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int n:gem){
            max=Math.max(n,max);
            min=Math.min(n,min);
        }

        return max-min;
    }
}
