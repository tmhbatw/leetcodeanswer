package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    /*Description
    * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    * */

    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        recursion(result,n,n,new StringBuilder());
        return result;
    }

    private void recursion(List<String> result,int left1,int left2,StringBuilder sb){
        if(left1==left2&&left1==0){
            result.add(sb.toString());
            return;
        }
        if(left1>0){
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append("(");
            recursion(result,left1-1,left2,curSb);
        }
        if(left2>left1){
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append(")");
            recursion(result,left1,left2-1,curSb);
        }
    }
}
