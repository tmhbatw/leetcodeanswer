package leetcode.leetcode12;

public class Leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int[] num=getRes(chars);
        int count=0;
        for(String cur:words){
            int[] c=getRes(cur);
            boolean reached=true;
            for(int i=0;i<26&&reached;i++){
                if(c[i]>num[i])
                    reached=false;
            }
            if(reached)
                count+=cur.length();
        }
        return count;
    }

    private int[] getRes(String s){
        int[] num=new int[26];
        for(int i=0;i<s.length();i++)
            num[s.charAt(i)-'a']++;
        return num;
    }
}
