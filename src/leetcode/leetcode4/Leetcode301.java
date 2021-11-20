package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode301 {

    Set<String> result=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int removeL=0;
        int removeR=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                removeL++;
            if(s.charAt(i)==')'){
                if(removeL==0)
                    removeR++;
                else
                    removeL--;
            }
        }
        System.out.println(removeL+" "+removeR);
        dfs(s,0,removeL,removeR,0,new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(String s,int index,int removeL,int removeR,int cur,StringBuilder sb){
        if(s.length()-index<removeL+removeR)
            return;
        if(s.length()==index){
            if(removeL==0&&removeR==0&&cur==0){
                result.add(sb.toString());
            }
            return;
        }
        if(s.charAt(index)=='('){
            if(removeL>0){
                StringBuilder newSb=new StringBuilder(sb);
                dfs(s,index+1,removeL-1,removeR,cur,newSb);
            }
            StringBuilder newSb=new StringBuilder(sb);
            newSb.append('(');
            dfs(s,index+1,removeL,removeR,cur+1,newSb);
        }
        else if(s.charAt(index)==')'){
            if(removeR>0){
                StringBuilder newSb=new StringBuilder(sb);
                dfs(s,index+1,removeL,removeR-1,cur,newSb);
            }
            if(cur>0){
                StringBuilder newSb=new StringBuilder(sb);
                newSb.append(')');
                dfs(s,index+1,removeL,removeR,cur-1,newSb);
            }
        }else{
            sb.append(s.charAt(index));
            dfs(s,index+1,removeL,removeR,cur,sb);
        }
    }

    public static void main(String[] args){
        System.out.println(new Leetcode301().removeInvalidParentheses("}}()())))()())))))("));
    }
}
