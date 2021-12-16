package leetcode.leetcode18;

import java.util.*;

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


   //建立一个 grid, 用 dfs 填满数值，再用 bfs 遍历 grid，计算最短路径。
   int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 上，下，左，右
    char[] FORWARD = {'U', 'D', 'L', 'R'};   // 上，下，左，右
    char[] BACKWARD = {'D', 'U', 'R', 'L'};  // 下，上，右，左

    int BLOCK = 3;
    int START = -1;
    int TARGET = 2;
    int EMPTY = 1;
    int UNVISITED = 0;

    int[][] grid;
    int N;

    public int findShortestPath(GridMaster master) {
        N = 10001;
        grid = new int[N][N];
        int startX = 5001;
        int startY = 5001;

        // dfs 寻找target，顺便建图
        dfs(startX, startY, master);

        // bfs 遍历图，计算最短路径
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        grid[startX][startY] = BLOCK;
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + DIRS[i][0];
                    int y = cur[1] + DIRS[i][1];
                    if (grid[x][y] == TARGET) return dis + 1;
                    if (grid[x][y] == BLOCK) continue;
                    grid[x][y] = BLOCK;
                    q.offer(new int[]{x, y});
                }
            }
            dis++;
        }
        return -1;
    }
    private void dfs(int i, int j, GridMaster master) {
        if (grid[i][j] != UNVISITED) return;
        if (master.isTarget())
            grid[i][j] = TARGET;
        else
            grid[i][j] = EMPTY;

        for (int k = 0; k < 4; k++) {
            char forward = FORWARD[k];
            char backward = BACKWARD[k];

            int x = i + DIRS[k][0];
            int y = j + DIRS[k][1];

            if (master.canMove(forward)) {
                master.move(forward);
                dfs(x, y, master);
                master.move(backward);
            } else
                grid[x][y] = BLOCK;
        }
    }


}
