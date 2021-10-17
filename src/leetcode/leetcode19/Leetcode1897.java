package leetcode.leetcode19;

public class Leetcode1897 {

    public boolean makeEqual(String[] words) {
        int[] num=new int[26];
        for(String cur:words){
            for(int i=0;i<cur.length();i++){
                num[cur.charAt(i)-'a']++;
            }
        }
        int n=words.length;
        for(int cur:num){
            if(cur%n!=0)
                return false;
        }
        return true;
    }
}
