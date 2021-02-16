package leetcode3;

import java.util.Arrays;
import java.util.Locale;

public class Leetcode294 {
    /*Description
    * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有+和-的字符串。你和朋友轮流将连续 的两个"++"反转成"--"。
    * 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。请你写出一个函数来判定起始玩家是否存在必胜的方案。
    * */

    public boolean canWin(String s) {
        char[] c=s.toCharArray();
        return canWin(c);
    }

    private boolean canWin(char[] c){
        boolean result=false;
        for(int i=0;i<c.length-1;i++){
          //  System.out.println("c"+i+"is "+c[i]+" c"+(i+1)+"is "+c[i+1]);
            if(c[i]=='+'&&c[i+1]=='+'){
              //  System.out.println(Arrays.toString(c));
                c[i]=c[i+1]='-';
                if(!canWin(c))
                    result=true;
                c[i]=c[i+1]='+';
                if(result)
                    break;
              //  System.out.println(Arrays.toString(c));
            }
        }
        return result;
    }

    public static void main(String[]args){
        String test="+++++++";
        System.out.println(new Leetcode294().canWin(test));
    }
}
