package interview;

public class Problem1_5 {
    /*Description
    * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
    * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * */

    public boolean oneEditAway(String first, String second) {
        for(int i=0;i<Math.min(first.length(),second.length());i++){
            if(first.charAt(i)!=second.charAt(i)) {
                return first.substring(i + 1).equals(second.substring(i + 1)) ||
                        first.substring(i + 1).equals(second.substring(i)) ||
                        first.substring(i).equals(second.substring(i + 1));
            }
        }
        return Math.abs(first.length()-second.length())<=1;
    }
}
