package leetcode5;

public class Leetcode408 {
    /*Description
     * 给一个非空字符串s和一个单词缩写abbr，判断这个缩写是否可以是给定单词的缩写。
     *字符串"word"的所有有效缩写为：
     * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d",
     *  "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     * 注意单词"word"的所有有效缩写仅包含以上这些。任何其他的字符串都不是"word"的有效缩写。
     * 注意:假设字符串s仅包含小写字母且abbr 只包含小写字母和数字
     */

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] w=word.toCharArray();
        int wLength=w.length;
        int index=0;
        int length=abbr.length();
        for(int i=0;i<length;i++){
            if(index>=wLength)
                return false;
            char cur=abbr.charAt(i);
            if(cur=='0')
                return false;
            if(isInteger(cur)){
                int number=cur-'0';
                while(i<length-1&&isInteger(abbr.charAt(i+1))){
                    number=number*10+abbr.charAt(++i)-'0';
                }
                index+=number;
            }else if(cur!=w[index])
                return false;
            else
                index++;
        }
        return index==wLength;
    }

    private boolean isInteger(char cur){
        return cur<='9'&&cur>='0';
    }

}
