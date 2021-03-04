package interview;

public class Problem5_2 {
    /*Description
    *二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
    * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”
    *             * */

    public String printBin(double num) {
        StringBuilder sb=new StringBuilder();
        sb.append("0.");
        while(num!=0){
            if(sb.length()==32)
                return "ERROR";
            num*=2;
            if(num>=1) {
                sb.append(1);
                num-=1;
            }else
                sb.append(0);
        }
        return sb.toString();
    }
}
