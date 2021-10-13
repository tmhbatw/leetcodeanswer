package leetcode.leetcode9;

public class Leetcode800 {
    /*Description
    *RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。
    * 例如，"#15c" 其实是 "#1155cc" 的简写。
    * 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2 来计算。
    *
    * 那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可以表示成类似 "#XYZ" 的形式）
    * 任何 具有相同的（最大）相似度的答案都会被视为正确答案。
    * */

    public String similarRGB(String color) {
        StringBuilder sb=new StringBuilder("#");
        for(int i=1;i<6;i+=2){
            String cur=color.substring(i,i+2);
            char curr=getRes(cur);
            sb.append(curr).append(curr);
        }
        return sb.toString();
    }

    private char getRes(String cur){

        int val=getVal(cur.charAt(0))*16+getVal(cur.charAt(1));

        int result=0;
        int res=val;
        for(int i=1;i<16;i++){
            int curVal=i*16+i;
            if(Math.abs(curVal-val)<res){
                result=i;
                res=Math.abs(curVal-val);
            }
        }
        return result<10?(char)(result+'0'):(char)(result-10+'a');
    }

    private int getVal(char cur){
        if(cur<='9'&&cur>='0')
            return cur-'0';
        return cur-'a'+10;
    }
}
