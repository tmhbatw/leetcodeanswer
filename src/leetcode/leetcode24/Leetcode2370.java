package leetcode.leetcode24;

public class Leetcode2370 {

    public int longestIdealString(String s, int k) {
        int[] time=new int[26];
        int result=0;
        for(char c:s.toCharArray()){
            int max=0;
            // System.out.println(c+" "+Math.max(0,c-'a'-k)+" "+Math.max(26,c-'a'+k+1));
            // System.out.println(Arrays.toString(time));
            for(int i=Math.max(0,c-'a'-k);i<Math.min(26,c-'a'+k+1);i++)
                max=Math.max(max,time[i]);

            time[c-'a']=max+1;
            result=Math.max(result,max+1);
        }

        return result;
    }

}
