package leetcode.leetcode21;

public class Leetcode2067 {

    public int equalCountSubstrings(String s, int count) {
        int[][] time=new int[s.length()+1][26];
        int result=0;
        for(int i=0;i<s.length();i++){
            time[i+1] = time[i].clone();
            char cur = s.charAt(i);
            time[i+1][cur-'a']++;

            for(int j=count;j<=count*26;j+=count){
                if(i-j<-1)
                    break;
                if(isMatch(time[i+1-j],time[i+1],count)){
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMatch(int[] time1, int[] time2, int count){
        for(int i=0;i<time1.length;i++){
            if((time2[i]-time1[i])!=count&&time2[i]!=time1[i])
                return false;
        }
        return true;
    }
}
