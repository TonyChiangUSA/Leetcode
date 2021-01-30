package Pony;

import java.util.*;

public class shortestDistance {
    private int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];

        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    if (!bfs(grid, i, j, dist, canReach)) return -1;
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings &&
                        dist[i][j] < minDis) {
                    minDis = dist[i][j];
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private boolean bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir:dirs){
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (!isValid(grid, newX, newY, visited)) continue;
                    if (grid[newX][newY] == 0) {
                        dist[newX][newY] += d;
                        canReach[newX][newY]++;
                        q.offer(new int[]{newX, newY});
                    }
                    visited[newX][newY] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        if (x > grid.length - 1 ||
                x < 0 || y < 0 || y > grid[0].length - 1) return false;
        if (visited[x][y]) return false;
        if(grid[x][y] == 2) return false;

        return true;
    }
}
