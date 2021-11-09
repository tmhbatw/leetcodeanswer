package leetcode.leetcode13;

public class Leetcode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int length=s.length();
        int j=-1;
        int count=0;
        int result=0;
        for(int i=0;i<length;i++){
            while(j<length-1&&Math.abs(s.charAt(j+1)-t.charAt(j+1))+count<=maxCost)
                count+=Math.abs(s.charAt(j+1)-t.charAt(++j));
            result=Math.max(result,j-i+1);
            count-=Math.abs(s.charAt(i)-t.charAt(i));
        }
        return result;
    }
}
