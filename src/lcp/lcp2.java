package lcp;

public class lcp2 {
    /*Description
    * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
    * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
    * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
    * 返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
    * */

    public int[] fraction(int[] cont) {
        int length=cont.length;
        int m=cont[length-1];
        int n=1;
        for(int i=length-2;i>=0;i--){
            int temp=n;
            n=m;
            m=temp;
            m+=cont[i]*n;
        }
        return new int[]{m,n};
    }


}
