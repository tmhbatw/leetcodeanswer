package interview;

import java.util.Arrays;
import java.util.Comparator;

public class Problem8_13 {

    /*Description
    * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、
    * 高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
    * 输入使用数组[wi, di, hi]表示每个箱子。
    * */

    public int pileBox(int[][] box) {
        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int length=box.length;
        int[] res=new int[length];
        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                if(box[i][0]>box[j][0]&&box[i][1]>box[j][1]&&box[i][2]>box[j][2]){
                    res[i]=Math.max(res[i],res[j]);
                }
            }
            res[i]+=box[i][2];
        }
        int result=0;
        for(int cur:res){
            result=Math.max(result,cur);
        }
        return result;
    }
}
