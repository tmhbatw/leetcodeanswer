package interview;

public class Problem5_8 {
    /*Description
    *绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，
    * 且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
    * 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。

    * */

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] result = new int[length];
        int offset=y*w/32;
        int head = x1 / 32 + offset;
        int end = x2 / 32 + offset;
        for (int i = head; i <= end; i++)
            result[i] = -1;
        result[head] = result[head] & -1 >>> x1 % 32;
        // 调整末位数字
        result[end] = result[end] & Integer.MIN_VALUE >> x2 % 32;
        return result;
    }
}
