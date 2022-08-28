package leetcode.leetcode24;

public class Leetcode2384 {

    public String largestPalindromic(String num) {
        int[] time=new int[10];
        for(char c:num.toCharArray())
            time[c-'0']++;
        StringBuilder sb=new StringBuilder();
        for(int i=9;i>=0;i--){
            if(i==0&&sb.length()==0)
                continue;
            for(int j=0;j<time[i]/2;j++){
                sb.append(i);
            }
        }
        for(int i=9;i>=0;i--){

            if(time[i]%2==1||i==0&&sb.length()==0)
                return sb.toString()+i+ sb.reverse();
        }
        return sb.toString()+sb.reverse();
    }


}
