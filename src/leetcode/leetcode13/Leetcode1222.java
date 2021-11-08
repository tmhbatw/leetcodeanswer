package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;

public class Leetcode1222 {

    int row=8,col=8;
    int[][] nextPos=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,1},{1,0},{1,-1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int[] queen:queens)
            set.add(queen[0]*8+queen[1]);
        for(int[] next:nextPos){
            int i=king[0]+next[0],j=king[1]+next[1];
            while(i>=0&&i<row&&j>=0&&j<col){
                if(set.contains(i*8+j)){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                    break;
                }
                i+=next[0];
                j+=next[1];
            }
        }
        return result;
    }
}
