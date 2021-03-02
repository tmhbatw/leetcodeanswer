package forOffer;

public class forOffer58_1 {
    /*Description
    * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
    * 例如输入字符串"I am a student. "，则输出"student. a am I"。
    * */

    public String reverseWords(String s) {
        String[] ss=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=ss.length-1;i>=0;i--) {
            if(ss[i].length()!=0)
            sb.append(" ").append(ss[i]);
        }
        return sb.length()==0?"":sb.substring(1);
    }
}
