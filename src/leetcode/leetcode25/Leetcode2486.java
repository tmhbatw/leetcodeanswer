package leetcode.leetcode25;

public class Leetcode2486 {

    public int appendCharacters(String s, String t) {
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<t.length()&&s.charAt(i)==t.charAt(j))
                j++;
        }
        return t.length()-j;
    }

}
