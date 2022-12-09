package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2178. 미로탐색
queue 에 배열을 넣는 이유.. 0,0 > 1,0 등으로 x, y 에 따라 사방향???
4 6
101111
101010
101011
111011
 */
public class BfsMain4 {
    static int N,M;
    static int[][] graph;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static Queue<int[]> queue = new LinkedList();
    //static Queue<Integer> queue = new LinkedList();
    static boolean[][] visited;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        // 미로 만들기(인접행렬)
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                graph[i][j]=line.charAt(j)-'0';
            }
        }
/*
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }*/
        bfs(0, 0);
        System.out.println(graph[N-1][M-1]);
    }

    static void bfs(int x, int y){
       // queue.offer(graph[x][y]);
        queue.offer(new int[]{0,0});
        visited[x][y]=true;
       // graph[x][y]=cnt;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            //int now = queue.poll();
            for (int[] dir : dirs) {

                int nextX = dir[0] + now[0];
               // int nextX = dir[0] + x;
                int nextY = dir[1] + now[1];
               // int nextY = dir[1] + y;
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                   // cnt++;
                    visited[nextX][nextY]=true;
                    graph[nextX][nextY] = graph[now[0]][now[1]] + 1;
                 //   graph[nextX][nextY] = now + 1;
                    queue.offer(new int[]{nextX,nextY});
                  //  queue.offer(graph[nextX][nextY]);
                }
            }
        }

    }
}
