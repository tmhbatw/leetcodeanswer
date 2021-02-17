package leetcode4;

public class Leetcode340 {
    /*Description
    * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
     * */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)
            return 0;
        int[] number=new int[128];
        int index=0;
        for(;index<s.length();index++){
            if(number[s.charAt(index)]==0&&k==0)
                break;
            if(number[s.charAt(index)]==0)
                k--;
            number[s.charAt(index)]++;
        }
        System.out.println(index);
        int result=index;
        int start=0;
        for(;index<s.length();index++){
            if(number[s.charAt(index)]==0){
                while(true){
                    number[s.charAt(start)]--;
                    if(number[s.charAt(start++)]==0)
                        break;
                }
            }
            number[s.charAt(index)]++;
            result=Math.max(result,index-start+1);
        }
        return result;
    }
}
