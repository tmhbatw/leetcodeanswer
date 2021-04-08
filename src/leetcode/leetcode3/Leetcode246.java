package leetcode.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode246 {
    /*Description
    * 中心对称数是指一个数字在旋转了180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
    * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
    * */

    /*Solution
    *       "6" : "9",
            "9" :"6",
            "8" : "8",
            "1" : "1",
            "0" :" 0"
    * */
    public boolean isStrobogrammatic(String num) {
        if(num==null||num.length()==0)
            return true;
        Map<Character,Character> map=new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        map.put('0','0');
        map.put('1','1');
        int length=num.length();
        for(int i=0;i<length/2+1;i++){
            if(map.getOrDefault(num.charAt(i),' ')!=num.charAt(length-i-1))
                return false;
        }
        return true;
    }
}
