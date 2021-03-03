package forOffer;

public class forOffer48 {
    /*Description
    * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * */

    public int lengthOfLongestSubstring(String s) {
        int pre=0;
        boolean[] reached=new boolean[128];
        int result=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(!reached[cur]){
                reached[cur]=true;
            }else{
                result=Math.max(result,i-pre);
                while(s.charAt(pre)!=cur){
                    reached[s.charAt(pre++)]=false;
                }
                pre++;
            }
        }
        return Math.max(result,s.length()-pre);
    }
}
