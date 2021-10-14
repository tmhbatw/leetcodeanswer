package leetcode.leetcode12;

public class Leetcode1189 {

    // balloon
    public int maxNumberOfBalloons(String text) {
        int[] num=new int[26];
        for(int i=0;i<text.length();i++)
            num[text.charAt(i)-'a']++;
        int res=Integer.MAX_VALUE;
        res= num[0];
        res=Math.min(res,num[1]);
        res=Math.min(res,num['n'-'a']);
        res=Math.min(res,num['l'-'a']/2);
        res=Math.min(res,num['o'-'a']/2);
        return res;
    }
}
