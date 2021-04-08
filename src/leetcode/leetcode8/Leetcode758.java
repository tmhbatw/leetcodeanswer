package leetcode.leetcode8;

public class Leetcode758 {
    /*Description
    * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 和  中的字母都会加粗。
    * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
    * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "aabcd"。注意返回 "aabcd" 会使用更多的标签，因此是错误的。
    * */

    public String boldWords(String[] words, String S) {
        int l=S.length();
        int[] dp=new int[S.length()+1];
        for(String cur:words){
            int length=cur.length();
            int start=0;
            while(S.indexOf(cur,start)!=-1){
                int curr=S.indexOf(cur,start);
                dp[curr]++;
                dp[curr+length]--;
                start=curr+1;
            }
        }
        for(int i=1;i<=l;i++){
            dp[i]+=dp[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l;i++){
            if(dp[i]==0){
                sb.append(S.charAt(i));
            }else{
                sb.append("<b>");
                sb.append(S.charAt(i));
                while(i<l-1&&dp[i+1]>0){
                    sb.append(S.charAt(++i));
                }
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
