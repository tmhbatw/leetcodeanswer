package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer85 {

    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,new StringBuilder());
        return result;
    }

    private void dfs(int i,int j,int n,StringBuilder sb){
        if(i==n&&j==n){
            result.add(sb.toString());
            return;
        }

        if(i<n){
            StringBuilder newSb=new StringBuilder(sb);
            newSb.append("(");
            dfs(i+1,j,n,newSb);
        }
        if(i>j){
            StringBuilder newSb=new StringBuilder(sb);
            newSb.append(")");
            dfs(i,j+1,n,newSb);
        }
    }
}
