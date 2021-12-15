package leetcode.leetcode4;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode353 {

    class SnakeGame {

        int length=0;
        int width;
        int height;
        boolean[][] reached;
        Queue<int[]> q;
        int[][] food;
        int i;
        int j;
        public SnakeGame(int width, int height, int[][] food) {
            this.width=width;
            this.height=height;
            this.reached=new boolean[width][height];
            this.q=new LinkedList<>();
            q.add(new int[]{0,0});
            this.food=food;
            this.i=0;
            this.j=0;
        }

        public int move(String direction) {
            switch (direction){
                case "U":
                    i--;
                    break;
                case "D":
                    i++;
                    break;
                case "R":
                    j++;
                    break;
                default:
                    j--;
            }

            if(i<0||i>=width||j<0||j>=height)
                return -1;

            if(length<food.length&&i==food[length][0]&&j==food[length][1]){
                reached[i][j]=true;
                q.add(new int[]{i,j});
                length++;
                return length;
            }

            int[] leave=q.poll();
            reached[leave[0]][leave[1]]=false;

            if(reached[i][j])
                return -1;
            reached[i][j]=true;
            q.add(new int[]{i,j});
            return length;
        }

        private void leave(int i,int j){
            int[] l=q.poll();
            reached[l[0]][l[1]]=false;
            reached[i][j]=true;
            q.add(new int[]{i,j});
        }
    }
}
