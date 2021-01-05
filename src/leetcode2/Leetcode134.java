package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode134 {
    /*Description
    * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
    * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站
    * 需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
    * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
    * 说明:
    * 如果题目有解，该答案即为唯一答案。
    * 输入数组均为非空数组，且长度相同。
    * 输入数组中的元素均为非负数。
    * */

    /*Solution
    * 假设从第i个加油站能跑到第j个加油站，没法跑到第j+1个加油站
    * 那么从i到j之间的任何一个加油站，均没法跑到第j+1个加油站（带剩余的油都没法跑过去，不带余油当然更不可能跑过去了）
    * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> list=new ArrayList<>();
        int length=gas.length;
        for(int i=0;i<length;i++)
            list.add(gas[i]-cost[i]);
        for(int i=0;i<length-1;i++)
            list.add(list.get(i));
        for(int i=0;i<length;i++){
            int cur=0;
            for(int j=i;j<i+length;j++){
                cur+=list.get(j);
                if(cur<0){
                    i=j;
                    break;
                }
                if(j==i+length-1)
                    return i;
            }
        }
        return -1;
    }
}
