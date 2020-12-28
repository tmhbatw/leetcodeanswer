package leetcode1;

public class Leetcode3 {
    /*Description
    * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * */

    public int lengthOfLongestSubstring(String s) {
        int[] c=new int[128];
        int first=0;
        int index=0;
        int length=s.length();
        int result=0;
        while(index<length){
            char cur=s.charAt(index);
            if(c[cur]!=0){
                result=Math.max(index-first,result);
                while(s.charAt(first)!=cur){
                    c[s.charAt(first++)]--;
                }
                first++;
            }
            else{
                c[cur]++;
            }
            index++;
        }
        return Math.max(result,index-first);
    }
}
