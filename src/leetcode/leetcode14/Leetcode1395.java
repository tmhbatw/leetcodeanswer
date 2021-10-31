package leetcode.leetcode14;

public class Leetcode1395 {

    public int numTeams(int[] rating) {
        int result=0;

        for(int i=1;i<rating.length-1;i++){
            int l1=0;
            int b1=0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i])
                    l1++;
                if(rating[j]>rating[i])
                    b1++;
            }
            int b2=0;
            int l2=0;
            for(int j=rating.length-1;j>i;j--){
                if(rating[j]>rating[i])
                    b2++;
                if(rating[j]<rating[i])
                    l2++;
            }
            result+=l1*b2+b1*l2;
        }
        return result;
    }
}
