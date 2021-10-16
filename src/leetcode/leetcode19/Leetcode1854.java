package leetcode.leetcode19;

public class Leetcode1854 {

    public int maximumPopulation(int[][] logs) {
        int[] res=new int[102];
        for(int[] log:logs){
            res[log[0]-1950]++;
            res[log[1]-1950]--;
        }
        int result=0;
        int year=0;
        for(int i=0;i<=100;i++){
            if(i>0)
                res[i]+=res[i-1];
            if(res[i]>result){
                year=i;
                result=res[i];
            }
        }
        return 1950+year;
    }
}
