package leetcode.leetcode20;

public class Leetcode1974 {

    public int minTimeToType(String word) {
        char pre='a';
        int count=0;
        for(int i=0;i<word.length();i++){
            count+=getRes(pre,word.charAt(i));
            pre=word.charAt(i);
        }
        return count+word.length();
    }

    private int getRes(char a,char b){
        int min=Math.min(a-'a',b-'a');
        int max=Math.max(a-'a',b-'a');
        return Math.min(max-min,min+26-max);
    }
}
