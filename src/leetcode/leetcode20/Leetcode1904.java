package leetcode.leetcode20;

public class Leetcode1904 {

    public int numberOfRounds(String loginTime, String logoutTime) {
        int[] t1=getTime(loginTime);
        int[] t2=getTime(logoutTime);

        if(t2[0]<t1[0]||t2[0]==t1[0]&&t2[1]<t1[1])
            t2[0]+=24;

        if(t1[0]==t2[0]){
            int start=getStart(t1[1]);
            int end=(t2[1])/15;
            return Math.max(0,end-start);
        }

        int result=(t2[0]-t1[0]-1)*4;
        result+=t2[1]/15+4-getStart(t1[1]);
        return result;
    }

    private int getStart(int cur){
        if(cur==0)
            return 0;
        return (cur-1)/15+1;
    }


    private int[] getTime(String time){
        int[] t=new int[2];
        t[0]=Integer.parseInt(time.substring(0,2));
        t[1]=Integer.parseInt(time.substring(3,5));
        return t;
    }


}
