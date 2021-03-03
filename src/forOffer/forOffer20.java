package forOffer;

public class forOffer20 {
    /*Description
    * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、
    * "-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
    * */

    public boolean isNumber(String s) {
        if(s.length()==0)
            return false;
        s=s.trim();
        boolean numFlag=false;
        boolean dotFlag=false;
        boolean eFlag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
                numFlag=true;
            }else if(s.charAt(i)=='.'&&!dotFlag&&!eFlag){
                dotFlag=true;
            }else if((s.charAt(i)=='E'||s.charAt(i)=='e')&&!eFlag&&numFlag){
                eFlag=true;
                numFlag=false;
            }else if((s.charAt(i)=='+'||s.charAt(i)=='-')&&(i==0||s.charAt(i-1)=='E'||s.charAt(i-1)=='e')){

            }else
                return false;
        }
        return numFlag;
    }
}
