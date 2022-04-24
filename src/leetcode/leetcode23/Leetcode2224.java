package leetcode.leetcode23;

public class Leetcode2224 {

    public int convertTime(String current, String correct) {
        int t1=getTime(current);
        int t2=getTime(correct);
        int diff=t2-t1;
        if(diff<0)
            diff+=1440;

        int result=0;
        int[] num=new int[]{60,15,5,1};
        for(int n:num){
            result+=diff/n;
            diff%=n;
        }

        return result;
    }

    private int getTime(String s){
        String[] cur=s.split(":");
        return Integer.parseInt(cur[0])*60+Integer.parseInt(cur[1]);
    }
}
