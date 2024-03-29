package lcp;

public class lcp12 {
    /*Description
    *为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，
    * 并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
    * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，
    * 通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
    * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
    * */

    public int minTime(int[] time, int m) {
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(mid,time,m))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean  isMatch(int T,int[] time, int m){
        int count=0;
        int length=time.length;
        for(int i=0;i<length;i++){
            int curSum=0;
            int curMax=time[i];
            while(i<length-1&&curSum+Math.min(curMax,time[i+1])<=T){
                curSum+=Math.min(curMax,time[i+1]);
                curMax=Math.max(curMax,time[++i]);
            }
            count++;
        }
        return count<=m;
    }


}
