package leetcode.leetcode8;

public class Leetcode744 {
    /*Description
    * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
    * 在比较时，字母是依序循环出现的。举个例子：
    * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
    * */

    public char nextGreatestLetter(char[] letters, char target) {
        int min=256;
        for(char cur:letters){
            if(cur>=target)
                min=Math.min(cur,min);
        }
        return min==256?letters[0]:(char)min;
    }
}
