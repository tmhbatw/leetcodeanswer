package leetcode.leetcode23;

public class Leetcode2278 {

    public int percentageLetter(String s, char letter) {
        int cur = 0;
        for(char c:s.toCharArray()){
            if(c==letter)
                cur++;
        }

        return cur*100/s.length();
    }
}
