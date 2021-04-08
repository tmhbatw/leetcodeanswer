package leetcode.leetcode5;

public class Leetcode405 {
    /*Description
    * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
    * 注意:十六进制中所有字母(a-f)都必须是小写。
    * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；
    * 对于其他情况，十六进制字符串中的第一个字符将不会是0字符。给定的数确保在32位有符号整数范围内。
    * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
    * */

    public String toHex(int num) {
        if(num==0)
            return "0";
        boolean isNegative=false;
        if(num<=0) {
            isNegative=true;
            num+=1;
            num+=Integer.MAX_VALUE;
        }
        StringBuilder sb=new StringBuilder();
        char[] c=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num>0){
            sb.append(c[num%16]);
            num/=16;
        }
        if(isNegative){
            while(sb.length()<8)
                sb.append('0');
            sb.setCharAt(7,c[sb.charAt(7)-'0'+8]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        String s="ffffffff";
        int res=0;
        int count=1;
        for(int i=0;i<8;i++){
            res+=15*count;
            count*=16;
            System.out.println(res);
        }
        System.out.println(res);
    }
}
