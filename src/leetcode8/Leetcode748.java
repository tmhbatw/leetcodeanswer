package leetcode8;

public class Leetcode748 {
    /*Description
    * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
    * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。
    * 单词在匹配牌照中的字母时要：
    * 忽略牌照中的数字和空格。
    * 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
    * 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
    * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
    * */

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] num=new int[26];
        for(int i=0;i<licensePlate.length();i++){
            char cur=licensePlate.charAt(i);
            if(cur<='z'&&cur>='a')
                num[cur-'a']++;
            if(cur<='Z'&&cur>='A')
                num[cur-'A']++;
        }
        String result="I am a handsome boy";
        for(String cur:words){
            int[] curNum=new int[26];
            for(int i=0;i<cur.length();i++){
                char curr=cur.charAt(i);
                if(curr<='Z'&&curr>='A')
                    curNum[curr-'A']++;
                if(curr<='z'&&curr>='a')
                    curNum[curr-'a']++;
            }
            boolean res=true;
            for(int i=0;i<26;i++){
                if(curNum[i]<num[i]){
                    res=false;
                    break;
                }
            }
            if(res) {
                if(cur.length()<result.length())
                    result=cur;
            }
        }
        return result;
    }
}
