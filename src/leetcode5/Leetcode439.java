package leetcode5;

public class Leetcode439 {
    /*Description
    * 给定一个以字符串表示的任意嵌套的三元表达式，计算表达式的值。
    * 你可以假定给定的表达式始终都是有效的并且只包含数字 0-9, ?, :, T 和F (T 和F分别表示真和假）。
    * 注意：
    * 给定的字符串长度≤ 10000。
    * 所包含的数字都只有一位数。
    * 条件表达式从右至左结合（和大多数程序设计语言类似）。
    * 条件是T和F其一，即条件永远不会是数字。
    * 表达式的结果是数字0-9, T 或者F。
    * */

    public String parseTernary(String expression) {
        if(expression.length()==1)
            return expression;
        char res=expression.charAt(0);
        int time=1;
        int i=2;
        for(;i<expression.length();i++){
            char cur=expression.charAt(i);
            switch(cur){
                case ':':
                    time--;
                    break;
                case '?':
                    time++;
                    break;
            }
            if(time==0)
                break;
        }
        if(res=='T')
            return parseTernary(expression.substring(2,i));
        return parseTernary(expression.substring(i+1));
    }
}
