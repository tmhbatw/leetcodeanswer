package leetcode.leetcode4;

public class Leetcode319 {
    /*Description
    * 初始时有n个灯泡关闭。
    * 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
    * 第i 轮，每i个灯泡切换一次开关。 对于第n轮，你只切换最后一个灯泡的开关。
    * 找出n轮后有多少个亮着的灯泡。
    * */

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
