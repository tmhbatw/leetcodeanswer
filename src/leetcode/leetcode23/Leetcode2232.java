package leetcode.leetcode23;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode2232 {
    String result = "";
    int res=Integer.MAX_VALUE;
    public String minimizeResult(String expression) {
        int equalIndex=0;
        for(;equalIndex<expression.length();equalIndex++){
            if(expression.charAt(equalIndex)=='+')
                break;
        }
        for(int i=0;i<equalIndex;i++){
            for(int j=equalIndex+2;j<=expression.length();j++){
                String cur = expression.substring(0,i)+"("+expression.substring(i,j)+")"+
                        expression.substring(j);
                int curRes=getRes(cur);
                if(curRes<res){
                    res=curRes;
                    result=cur;
                }
            }
        }
        return result;
    }

    private int getRes(String cur){
        Stack<Character> character=new Stack<>();
        Stack<Integer> number=new Stack<>();
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)<='9'&&cur.charAt(i)>='0'){
                int num=cur.charAt(i)-'0';
                while(i<cur.length()-1&&cur.charAt(i+1)<='9'&&cur.charAt(i+1)>='0'){
                    num = num*10+cur.charAt(++i)-'0';
                }
                number.add(num);
            }else if (cur.charAt(i)=='+'){
                character.add('+');
            }else if(cur.charAt(i)=='('){
                if(i>0&&cur.charAt(i-1)<='9'&&cur.charAt(i-1)>='0')
                    character.add('*');
                character.add('(');
            }else if(cur.charAt(i)==')'){
                while(character.peek()!='('){
                    if(character.pop()=='*')
                        number.add(number.pop()*number.pop());
                    else
                        number.add(number.pop()+number.pop());
                }
                character.pop();
                if(i<cur.length()-1&&cur.charAt(i+1)<='9'&&cur.charAt(i+1)>='0')
                    character.add('*');
            }
        }

        while(!character.empty()){
            if(character.pop()=='*')
                number.add(number.pop()*number.pop());
            else
                number.add(number.pop()+number.pop());
        }
        return number.peek();
    }
}
