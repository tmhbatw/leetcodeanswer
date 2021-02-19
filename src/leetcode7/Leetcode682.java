package leetcode7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode682 {
    /*Description
    * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
    * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
    * 整数 x - 表示本回合新获得分数 x
    * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
    * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
    * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
    * 请你返回记录中所有得分的总和。
    * */

    public int calPoints(String[] ops) {
        Stack<Integer> q=new Stack<>();
        for(String cur:ops){
            if(cur.equals("D"))
                q.add(q.peek()*2);
            else if(cur.equals("C"))
                q.pop();
            else if(cur.equals("+")){
                int second=q.pop();
                int first=q.peek();
                q.add(second);
                q.add(first+second);
            }else
                q.add(Integer.parseInt(cur));
        }
        int result=0;
        for(int cur:q)
            result+=cur;
        return result;
    }
}
