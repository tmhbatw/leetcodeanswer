package leetcode.leetcode9;

public class Leetcode825 {

    public int numFriendRequests(int[] ages) {
        int[] time=new int[121];
        for(int num:ages)
            time[num]++;

        int result=0;
        int y=0;
        int cur=0;
        for(int x=0;x<=120;x++){
            cur+=time[x];
            while(y<=x*0.5+7) {
                cur-=time[y++];
            }
            result+=Math.max(0,(-1+cur)*time[x]);
        }

        return result;
    }

}
