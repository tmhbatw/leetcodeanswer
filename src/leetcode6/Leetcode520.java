package leetcode6;

public class Leetcode520 {
    /*Description
    * 给定一个单词，你需要判断单词的大写使用是否正确。
    * 我们定义，在以下情况时，单词的大写用法是正确的：
    * 全部字母都是大写，比如"USA"。
    * 单词中所有字母都不是大写，比如"leetcode"。
    * 如果单词不只含有一个字母，只有首字母大写，比如"Google"。
    * 否则，我们定义这个单词没有正确使用大写字母。
    * */
    public boolean detectCapitalUse(String word) {
        if(word.length()==1)
            return true;
        boolean firstIsUpper=false;
        if(word.charAt(0)<='Z')
            firstIsUpper=true;
        if(!firstIsUpper&&word.charAt(1)<='Z')
            return false;
        if(word.charAt(1)>'Z')
            firstIsUpper=false;
        for(int i=2;i<word.length();i++){
            boolean isUpper=word.charAt(i)<='Z';
            if(isUpper^firstIsUpper)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println((int)'Z');
        System.out.println((int)'z');
    }
}
