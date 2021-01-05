package leetcode2;

public class Leetcode157 {
    /*Description
    * 给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
    * */

    int read4(char[] buf4){
        return (int) Math.random();
    }

    public int read(char[] buf, int n) {
        char[] buf4=new char[4];
        int index=0;
        int number=0;
        while((number=read4(buf4))!=0&&index<n){
            for(int i=0;i<number;i++) {
                if(index>n)
                    break;
                buf[index++] = buf4[i];
            }
        }
        return index;
    }
}
