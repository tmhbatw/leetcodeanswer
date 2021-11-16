package leetcode.leetcode5;

public class Leetcode424 {

    public int characterReplacement(String s, int k) {
        int length=s.length();
        int result=0;
        int j=0;
        int[] num=new int[26];

        for(int i=0;i<length;i++){
            while(j<length&&isMatch(num,s.charAt(j),k)){
                num[s.charAt(j++)-'A']++;
            }
            result=Math.max(j-i,result);
            num[s.charAt(i)-'A']--;
        }
        return result;
    }

    private boolean isMatch(int[] num,char cur,int k){
        num[cur-'A']++;
        int max=0;
        int sum=0;
        for(int n:num){
            max=Math.max(n,max);
            sum+=n;
        }
        num[cur-'A']--;
        return sum-max<=k;
    }
}
