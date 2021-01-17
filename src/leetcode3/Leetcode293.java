package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode293 {
    /*Description
    * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有+和-的字符串。
    * 你和朋友轮流将连续 的两个"++"反转成"--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
    * 请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
    * */

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+')
                result.add(s.substring(0,i)+"--"+s.substring(i+2));
        }
        return result;
    }
}
