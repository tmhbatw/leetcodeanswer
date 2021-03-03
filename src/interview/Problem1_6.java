package interview;

public class Problem1_6 {
    /*Description
    * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
    * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
    * */

    public String compressString(String S) {
        int length=S.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            char cur=S.charAt(i);
            int start=i;
            while(i<length-1&&S.charAt(i+1)==cur){
                i++;
            }
            sb.append(cur).append(i-start+1);
        }
        return sb.length()<S.length()?sb.toString():S;
    }
}
