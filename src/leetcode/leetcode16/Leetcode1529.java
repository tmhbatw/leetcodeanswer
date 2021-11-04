package leetcode.leetcode16;

public class Leetcode1529 {

    public int minFlips(String target) {
        char pre='0';
        int count=0;
        int length=target.length();
        for(int i=0;i<length;i++){
            char c=target.charAt(i);
            if(c!=pre){
                count++;
                pre=c;
            }
        }
        return count;
    }
}
