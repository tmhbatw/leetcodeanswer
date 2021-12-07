package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1451 {

    class Word{
        int index;
        String word;
        int length;
        public Word(int index,String word){
            this.index=index;
            this.word=word;
            this.length=word.length();
        }
    }
    public String arrangeWords(String text) {
        String[] word=text.split(" ");
        word[0]=word[0].toLowerCase();

        Arrays.sort(word,(o1,o2)->{
            return o1.length()-o2.length();
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length;i++){
            if(i==0){
                char first=word[i].charAt(0);
                sb.append((char)(first-'a'+'A')).append(word[i].substring(1));
            }else{
                sb.append(" ").append(word[i]);
            }
        }
        return sb.toString();
    }
}
