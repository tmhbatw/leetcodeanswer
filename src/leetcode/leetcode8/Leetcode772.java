package leetcode.leetcode8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode772 {

    int index=0;
    int length;
    public int calculate(String s) {
        this.length=s.length();

        Stack<Character> op=new Stack<>();
        Stack<Integer> q=new Stack<>();

        for(;index<length;index++){
            char cur=s.charAt(index);
            switch (cur){
                case '(':
                    op.add('(');
                    break;
                case '+': case '-':
                    int level=1;
                    while(!op.isEmpty()&&getLevel(op.peek())>=level){
                        q.add(getRes(op.pop(),q.pop(),q.pop()));
                    }
                    op.add(cur);
                    break;
                case '*': case '/':
                    level=2;
                    while(!op.isEmpty()&&getLevel(op.peek())>=level){
                        q.add(getRes(op.pop(),q.pop(),q.pop()));
                    }
                    op.add(cur);
                    break;
                case ')':
                    while(op.peek()!='(')
                        q.add(getRes(op.pop(),q.pop(),q.pop()));
                    op.pop();
                    break;
                default:
                    q.add(getRes(s));
            }
        }

        while(!op.isEmpty())
            q.add(getRes(op.pop(),q.pop(),q.pop()));
        return q.pop();
    }

    private int getRes(char op,int n2,int n1){
        switch (op){
            case '+':
                return n1+n2;
            case '-':
                return n1-n2;
            case '*':
                return n1*n2;
            case '/':
                return n1/n2;
        }
        return -1;
    }

    private int getLevel(char cur){
        if(cur=='*'||cur=='/')
            return 2;
        if(cur=='+'||cur=='-')
            return 1;
        return 0;
    }

    private int getRes(String s){
        int cur=s.charAt(index)-'0';
        while(index<length-1&&s.charAt(index+1)<='9'&&s.charAt(index+1)>='0'){
            cur=cur*10+s.charAt(++index)-'0';
        }
        return cur;
    }

}
