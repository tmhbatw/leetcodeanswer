package leetcode.leetcode9;

public class Leetcode849 {

    public int maxDistToClosest(int[] seats) {
        int pre=-1;
        int result=0;

        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(pre==-1)
                    result=i;
                else
                    result=Math.max(result,(i-pre)/2);

                pre=i;
            }
        }
        return Math.max(result,seats.length-pre-1);
    }
}
