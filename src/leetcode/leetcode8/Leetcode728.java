package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode728 {
    /*Description
    * 自除数 是指可以被它包含的每一位数除尽的数。
    * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
    * 还有，自除数不允许包含 0 。
    * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
    * */

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isMatch(i))
                result.add(i);
        }
        return result;
    }

    private boolean isMatch(int cur){
        String s=String.valueOf(cur);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'||cur%(s.charAt(i)-'0')!=0)
                return false;
        }
        return true;
    }
}
