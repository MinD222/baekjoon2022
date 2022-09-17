package com.lecture.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Island (섬의 수)
 * Breadth First Search(BFS)
 *
 * 2차원배열 : 이중 for문
 */
public class bfsMain {

    public static void main(String[] args){

        char[][] grid = {
                {'1','1','0','0','0'}, // 00, 01, 02, 03, 04
                {'1','1','0','0','0'}, // 10, 11, 12, 13, 14
                {'1','1','0','0','0'}, // 20, 21, 22, 23, 24
                {'0','0','0','1','1'}  // 30, 31, 32, 33, 34
        };
        int n = grid.length; // 4 : 행 수
        int m = grid[0].length; // 5 : 열 수
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}}; // 방향
        int count = 0;
        for(int i=0; i< n;i++){
            for(int j=0; j <m;j++){
                if(grid[i][j]=='1'){
                    count ++;
                    grid[i][j] = 'X';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i,j});

                    // queue가 빌때까지 반복
                    while (!queue.isEmpty()){
                        // ??
                        int[] cur = queue.poll();

                        // 4방향 서치
                        for(int[] dir : dirs){
                            // 새로운 방향
                            int x1 = cur[0]+dir[0];
                            int y1 = cur[1]+dir[1];
                            if(x1 >= 0 && y1 >= 0 && x1 < n && y1 < m && grid[x1][y1] == '1' ){
                                System.out.println("X : " + x1 + " Y : " + y1);
                                grid[x1][y1] = 'X';
                                queue.offer(new int[] {x1,y1});
                            }
                        }
                    }

                }
            }
        }
        System.out.println(count);

    }
}
