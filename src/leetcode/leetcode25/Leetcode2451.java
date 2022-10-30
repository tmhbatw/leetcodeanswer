package leetcode.leetcode25;

public class Leetcode2451 {

    public String oddString(String[] words) {
        String normal=getNormal(words[0]);
        if(!getNormal(words[1]).equals(normal)){
            return getNormal(words[2]).equals(normal)?words[1]:words[0];
        }
        for(int i=2;i<words.length;i++){
            if(!getNormal(words[i]).equals(normal))
                return words[i];
        }
        return words[0];
    }

    private String getNormal(String word){
        char[] c=word.toCharArray();
        int diff=c[0]-'a';
        for(int i=0;i<c.length;i++){
            c[i]=(char)(c[i]-diff);
        }
        return new String(c);
    }
}
