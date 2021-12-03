package leetcode.leetcode20;

public class Leetcode1989 {

    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int j=0;
        int count=0;
        for(int i=0;i<team.length;i++){
            if(team[i]==1){
                j=Math.max(j,i-dist);
                while(j<=Math.min(team.length-1,i+dist)&&team[j]==1)
                    j++;
                if(j<=Math.min(team.length-1,i+dist)){
                    j++;
                    count++;
                }
            }
        }
        return count;
    }
}
