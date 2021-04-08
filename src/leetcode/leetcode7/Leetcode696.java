package leetcode.leetcode7;

public class Leetcode696 {
    /*Description
    * 给定一个字符串s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，
    * 并且这些子字符串中的所有 0 和所有 1 都是连续的。
    * 重复出现的子串要计算它们出现的次数。
    * */

    public int countBinarySubstrings(String s) {
        int length=s.length();
        int result=0;
        int pre=0;
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            int start=i;
            while(i<length-1&&s.charAt(i+1)==cur)
                i++;
            start=i-start+1;
            result+=Math.min(pre,start);
            pre=start;
        }
        return result;
    }
}
