package leetcode.leetcode9;

public class Leetcode806 {
    /*
    *
    * */

    int lineSize=100;
    public int[] numberOfLines(int[] widths, String s) {
        int count=0;
        int length=s.length();
        int pre=0;
        for(int i=0;i<length;i++){
            int cur=widths[s.charAt(i)-'a'];
            while(i<length-1&&cur+widths[s.charAt(i+1)-'a']<=lineSize){
                cur+=widths[s.charAt(++i)-'a'];
            }
            count++;
            pre=cur;
        }
        return new int[]{count,pre};
    }
}
