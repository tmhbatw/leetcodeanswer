package leetcode.leetcode2;

public class Leetcode158 {
    /*Description
    * 给你一个文件，并且该文件只能通过给定的read4方法来读取，请实现一个方法使其能够读取 n 个字符。
    * 注意：你的read 方法可能会被调用多次。
    * read4 的定义：
    * read4 API 从文件中读取 4 个连续的字符，然后将这些字符写入缓冲区数组 buf4 。
    * 返回值是读取的实际字符数。
    * */
    int read4(char[] buf4){
        return (int) (Math.random() * 4);
    }

    int capacity=0;
    int bufIndex=0;
    char[] buf4=new char[4];
    public int read(char[] buf, int n) {
        int index=0;
        int temp=0;
        for(int i=0;i<n;i++){
            if(bufIndex==0){
                capacity=read4(buf4);
            }
            if(bufIndex==capacity)
                return i;
            buf[i]=buf4[bufIndex];
            addBufIndex();
        }
        return n;
    }


    private void addBufIndex(){
        bufIndex++;
        if(bufIndex==4)
            bufIndex=0;
    }
}
