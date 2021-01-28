package leetcode5;

public class Leetcode434 {
    /*Description
    * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    * 请注意，你可以假定字符串里不包括任何不可打印的字符。
    * */

    public int countSegments(String s) {
        if(s==null)
            return 0;
        int length=s.length();
        int result=0;
        for(int i=0;i<length;i++){
            if(isLetter(s.charAt(i))){
                result++;
                while(i<length-1&&isLetter(s.charAt(i+1)))
                    i++;
            }
        }
        return result;
    }

    private boolean isLetter(char cur){
        return cur!=' ';
    }
}
