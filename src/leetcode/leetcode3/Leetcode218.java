package leetcode.leetcode3;

import java.util.*;

public class Leetcode218 {
    /*Description
    *城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
    * 给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
    * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
    * lefti 是第 i 座建筑物左边缘的 x 坐标。
    * righti 是第 i 座建筑物右边缘的 x 坐标。
    * heighti 是第 i 座建筑物的高度。
    * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。
    * 关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，
    * 仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
    * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5],
    *  [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
    * */

    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2])
                    return o1[0]-o2[0];
                return o1[2]-o2[2];
            }
        });
        for(int[] cur:buildings) {
            int start=cur[0];
            int end=cur[1];
            int height=cur[2];
            int preHeight=0;
            if(map.floorKey(start)!=null)
                preHeight=map.get(map.floorKey(start));
            while(map.ceilingKey(start)!=null){
                int key=map.ceilingKey(start);
                if(key>end)
                    break;
                preHeight=map.get(key);
                map.remove(key);
            }
            map.put(start,height);
            map.put(end,preHeight);
        }
        int cur=-1;
        List<List<Integer>> result=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            int val= (int) entry.getValue();
            if(cur==val)
                continue;
            cur=val;
            List<Integer> list=new ArrayList<>();
            list.add((int)entry.getKey());
            list.add(cur);
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,10);
        map.put(2,20);
        map.put(4,30);
        System.out.println(map);
        System.out.println(map.floorKey(-1)==null);
        System.out.println(map.ceilingKey(3));
    }
}
