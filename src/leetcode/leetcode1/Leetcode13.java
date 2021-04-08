package leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Leetcode13 {
    /*Description
    * 罗马数字转整数
    * 字符          数值
    * I             1
    * V             5
    * X             10
    * L             50
    * C             100
    * D             500
    * M             1000
    * */

    public int romanToInt(String s) {
        if(s==null||s.length()==0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int preVal=map.get(s.charAt(0));
        int result=0;
        for(int i=1;i<s.length();i++){
            int curVal=map.get(s.charAt(i));
            if(curVal>preVal){
                result-=preVal;
            }else{
                result+=preVal;
            }
            preVal=curVal;
        }
        result+=preVal;
        return result;
    }
}
