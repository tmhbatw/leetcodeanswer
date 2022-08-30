package leetcode.leetcode23;

public class Leetcode2207 {


    public long maximumSubsequenceCount(String text, String pattern) {
        int[] time=new int[text.length()+1];
        int sum = 0;
        for(int j=text.length()-1;j>=0;j--){
            if(text.charAt(j)==pattern.charAt(1)){
                time[j]++;
            }
            time[j]+=time[j+1];
        }

        long result = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==pattern.charAt(0)){
                sum++;
                result+=time[i+1];
            }
        }
        return result+Math.max(sum,time[0]);
    }

}
