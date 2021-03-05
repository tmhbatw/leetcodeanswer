package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem8_9 {
    /*Description
    * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
    * 说明：解集不能包含重复的子集。
    * 例如，给出 n = 3，生成结果为：
    * */

    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        dfs(n,n,new StringBuilder());
        return result;
    }

    private void dfs(int left,int right,StringBuilder sb){
        if(left==0&&right==0){
            result.add(sb.toString());
            return ;
        }
        if(left==right){
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append('(');
            dfs(1,left-1,curSb);
        }
        else if(left==0){
            sb.append(')');
            dfs(left,right-1,sb);
        }else{
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append('(');
            dfs(left-1,right,curSb);
            sb.append(')');
            dfs(left,right-1,sb);
        }
    }
}
