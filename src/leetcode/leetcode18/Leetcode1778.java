package leetcode.leetcode18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode1778 {
    class GridMaster {
        boolean canMove(char direction){
            return true;
        };
        void move(char direction){

        };
        boolean isTarget(){
            return true;
        };
    }

    int result=Integer.MAX_VALUE;
    public int findShortestPath(GridMaster master) {
        dfs(new HashSet(),master,0,0,0);
        return result==Integer.MAX_VALUE?-1:result;
    }

    char[] next=new char[]{'U','D','L','R'};
    private void dfs(Set<String> set, GridMaster master, int cur,int i,int j){
        set.add(i+" "+j);
        if(master.isTarget()){
            result=Math.min(result,cur);
        }else{
            for(char c:next){
                if(master.canMove(c)){
                    master.move(c);
                    dfs(master,cur+1);
                    moveBack(c,master);
                }
            }
        }
    }

    private void moveBack(char pre,GridMaster master){
        switch (pre){
            case 'U':
                master.move('D');
                break;
            case 'D':
                master.move('U');
                break;
            case 'R':
                master.move('L');
                break;
            case 'L':
                master.move('R');
                break;
        }
    }


}
