package leetcode.leetcode5;

import java.util.HashSet;
import java.util.Set;

public class Leetcode489 {

     interface Robot {
         // Returns true if the cell in front is open and robot moves into the cell.
         // Returns false if the cell in front is blocked and robot stays in the current cell.
         public boolean move();
         // Robot will stay in the same cell after calling turnLeft/turnRight.
         // Each turn will be 90 degrees.
         public void turnLeft();
         public void turnRight();

         // Clean the current cell.
         public void clean();
     }

    int[][] nextPos=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    Set<String> set=new HashSet<>();

    public void cleanRoom(Robot robot) {
        cleanRoom(robot,0,0,0);
    }

    public void cleanRoom(Robot robot,int i,int j,int d){
        if(set.contains(i+" "+j))
            return;
        set.add(i+" "+j);
        robot.clean();
        for(int jj=0;jj<4;jj++){
            int ii=(d+jj)%4;
            if(robot.move()){
                robot.move();
                cleanRoom(robot,i+nextPos[ii][0],j+nextPos[ii][1],d);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
            }else
                robot.turnLeft();
        }
    }


}
