package leetcode.leetcode8;

public class Leetcode789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis=Math.abs(target[0])+Math.abs(target[1]);
        for(int[] ghost:ghosts){
            int cur=Math.abs(ghost[0]-target[0])+Math.abs(ghost[1]-target[1]);
            if(cur<=dis)
                return false;
        }
        return true;
    }
}
