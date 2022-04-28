package leetcode.leetcode23;

public class Leetcode2237 {


    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] time=new int[n+1];
        for(int[] light:lights){
            int min=Math.max(0,light[0]-light[1]);
            int max=Math.min(n-1,light[0]+light[1]);
            time[min]++;
            time[max+1]--;
        }

        int result=0;
        for(int i=0;i<n;i++){
            if(i>=1)
                time[i]+=time[i-1];
            if(time[i]>=requirement[i])
                result++;
        }
        return result;
    }

}
