package leetcode.leetcode9;

public class Leetcode848 {

    public String shiftingLetters(String s, int[] shifts) {
        char[] c=s.toCharArray();
        long change=0;
        for(int i=c.length-1;i>=0;i--){
            change+=shifts[i];
            c[i]=(char)((change+c[i]-'a')%26+'a');
        }

        return new String(c);
    }

}
