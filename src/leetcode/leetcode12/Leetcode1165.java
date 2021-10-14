package leetcode.leetcode12;

public class Leetcode1165 {
    public int calculateTime(String keyboard, String word) {
        int[] num=new int[26];
        for(int i=0;i<keyboard.length();i++)
            num[keyboard.charAt(i)-'a']=i;
        int pre=0;
        int result=0;
        for(int i=0;i<word.length();i++){
            int next=num[word.charAt(i)-'a'];
            result+=getRes(next,pre);
            pre=next;
        }
        return result;
    }

    private int getRes(int i,int j){
        return Math.abs(i-j);
    }
}
