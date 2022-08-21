package leetcode.leetcode14;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1361 {

    //判断入度
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in = new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < leftChild.length; i++) {
            map.putIfAbsent(i,i);
            int type=getType(map,i);
            if (f(leftChild, in, map, i, type)) return false;
            if (f(rightChild, in, map, i, type)) return false;
        }

        int count = 0;
        for (int num : in) {
            if (num > 1)
                return false;
            if (num == 0)
                count++;
        }

        return count == 1;
    }

    private boolean f(int[] rightChild, int[] in, Map<Integer, Integer> map, int i, int type) {
        if (rightChild[i] != -1) {
            map.putIfAbsent(rightChild[i],rightChild[i]);
            if(getType(map,rightChild[i])==type)
                return true;
            map.put(rightChild[i],type );
            in[rightChild[i]]++;
        }
        return false;
    }

    private int getType(Map<Integer,Integer> map,int cur){
        if(map.get(cur)==cur)
            return cur;
        return getType(map,map.get(cur));
    }
}
