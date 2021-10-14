package leetcode.leetcode10;

public class Leetcode953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] num=new int[26];
        for(int i=0;i<order.length();i++){
            num[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            if(!isBigger(words[i-1],words[i],num))
                return false;
        }
        return true;
    }

    private boolean isBigger(String s1,String s2,int[] num){
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            int time1=num[s1.charAt(i)-'a'];
            int time2=num[s2.charAt(i)-'a'];
            if(time1==time2)
                continue;
            if(time1<time2)
                return true;
            return false;
        }
        return s1.length()<=s2.length();
    }
}
