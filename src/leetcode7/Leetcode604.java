package leetcode7;

public class Leetcode604 {
    /*Description
    * 对于一个压缩字符串，设计一个数据结构，它支持如下两种操作：next和hasNext。
    * 给定的压缩字符串格式为：每个字母后面紧跟一个正整数，这个整数表示该字母在解压后的字符串里连续出现的次数。
    * next() - 如果压缩字符串仍然有字母未被解压，则返回下一个字母，否则返回一个空格。
    * hasNext() - 判断是否还有字母仍然没被解压。
    * */

    class StringIterator {
        int index=0;
        char cur=' ';
        int time=0;
        String s;
        public StringIterator(String compressedString) {
            s=compressedString;
        }

        public char next() {
            if(!hasNext())
                return ' ';
            if(time==0){
                cur=s.charAt(index++);
                while(index<s.length()){
                    char cur=s.charAt(index);
                    if(cur<='9'&&cur>='0'){
                        time*=10;
                        time+=cur-'0';
                        index++;
                    }else
                        break;
                }
            }
            time--;
            return cur;
        }

        public boolean hasNext() {
            return index<s.length()||time>0;
        }
    }
}
