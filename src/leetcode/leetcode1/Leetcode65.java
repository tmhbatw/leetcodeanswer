package leetcode.leetcode1;

public class Leetcode65 {
    /*Description
    * 验证给定的字符串是否可以解释为十进制数字。
    * */

    public boolean isNumber(String s) {
        if(s==null||s.length()==0)
            return false;
        int sLength=s.length();
        int startIndex=0;
        while(startIndex<sLength&&s.charAt(startIndex)==' ')
            startIndex++;
        int endIndex=sLength-1;
        while(endIndex>=0&&s.charAt(endIndex)==' ')
            endIndex--;
        if(startIndex>endIndex)
            return false;
        if(s.charAt(startIndex)=='-'||s.charAt(startIndex)=='+')
            startIndex++;
        boolean num=false,dot=false,e=false;
        for(int i=startIndex;i<=endIndex;i++){
            char cur=s.charAt(i);
            if(cur<='9'&&cur>='0')
                num=true;
            else if(cur=='.'){
                if(dot||e)
                    return false;
                dot=true;
            }
            else if(cur=='e'){
                if(e||!num)
                    return false;
                e=true;
                num=false;
            }else if(cur=='+'||cur=='-') {
                if(i>0&&s.charAt(i-1)=='e')
                    continue;
                return false;
            }else
                return false;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(new Leetcode65().isNumber(" -90e3   "));
    }

}
