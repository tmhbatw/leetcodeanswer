package leetcode.leetcode7;

public class Leetcode616 {
    /*Description
    * 给一个字符串s和一个字符串列表dict，你需要将在字符串列表中出现过的 s 的子串
    * 添加加粗闭合标签<b>和</b>。如果两个子串有重叠部分，你需要把它们一起用一个闭合标签包围起来。
    * 同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一个加粗标签包围。
    * */
    public String addBoldTag(String s, String[] dict) {
        int length=s.length();
        int[] dp=new int[length+1];
        for(String cur:dict){
            int start=0;
            int startIndex;
            while((startIndex=s.indexOf(cur,start))!=-1){
                dp[startIndex]+=1;
                dp[startIndex+cur.length()]+=-1;
                start=startIndex+1;
            }

        }
        for(int i=1;i<length+1;i++){
            dp[i]+=dp[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            if(dp[i]==0)
                sb.append(s.charAt(i));
            else {
                sb.append("<b>");
                sb.append(s.charAt(i));
                while(i<length-1&&dp[i+1]>0){
                    i++;
                    sb.append(s.charAt(i));
                }
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
