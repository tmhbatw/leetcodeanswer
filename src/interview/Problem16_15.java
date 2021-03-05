package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem16_15 {
    /*Description
    * 珠玑妙算游戏（the game of master mind）的玩法如下。
    * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
    * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
    * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
    * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
    * */

    public int[] masterMind(String solution, String guess) {
        int[] res=new int[2];
        int[] time1=new int[4];
        int[] time2=new int[4];
        for(int i=0;i<4;i++){
            char cur1=solution.charAt(i);
            char cur2=guess.charAt(i);
            if(cur1==cur2) {
                res[0]++;
            }else{
                int index1=getIndex(cur1);
                if(time2[index1]>0){
                    res[1]++;
                    time2[index1]--;
                }else{
                    time1[index1]++;
                }
                int index2=getIndex(cur2);
                if(time1[index2]>0){
                    res[1]++;
                    time1[index2]--;
                }else
                    time2[index2]++;
            }
        }
        return res;
    }

    private int getIndex(char cur){
        switch(cur){
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }
}
