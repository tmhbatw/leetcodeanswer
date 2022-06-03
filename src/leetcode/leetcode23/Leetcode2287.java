package leetcode.leetcode23;

public class Leetcode2287 {

    public int rearrangeCharacters(String s, String target) {
        int[] time1=getTime(s);
        int[] time2=getTime(target);

        int result=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(time2[i]==0)
                continue;

            result=Math.min(result,time1[i]/time2[i]);
        }

        return result;
    }

    private int[] getTime(String s){
        int[] time=new int[26];
        for(char c:s.toCharArray())
            time[c-'a']++;
        return time;
    }

}
