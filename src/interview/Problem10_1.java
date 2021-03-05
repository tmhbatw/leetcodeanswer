package interview;

public class Problem10_1 {
    /*Description
    * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
    * 初始化 A 和 B 的元素数量分别为 m 和 n。
    * */

    public void merge(int[] A, int m, int[] B, int n) {
        int indexA=m-1;
        int indexB=n-1;
        int index=m+n-1;
        while(index>=0) {
            int valA=indexA>=0?A[indexA]:Integer.MIN_VALUE;
            int valB=indexB>=0?B[indexB]:Integer.MIN_VALUE;
            if (valA > valB) {
                A[index--]=valA;
                indexA--;
            }else{
                A[index--]=valB;
                indexB--;
            }
        }
    }
}
