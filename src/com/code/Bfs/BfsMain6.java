package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsMain6 {
    static int N,M,S;
    static int[][] graph;
    static int cnt;
    static int check; // check가 N*M 보다 작으면 다 못익은 것...
    static int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    static int[][] start;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //6
        M = Integer.parseInt(st.nextToken()); //4

        graph = new int[M][N];
        start = new int[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        S=0;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==1){ // 익은 토마토가 있는 경우 탐색 시작
                    //bfs(i, j);
 /*                   start[S]=new int[]{i,j};
                    S++;*/
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==0){ // 안익은 곳이 있는 경우 출력 -1
                    cnt=-1;
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(){
/*        for(int[] st : start){
            queue.offer(st[]); // 시작점들 !!
        }*/
        while (!queue.isEmpty()){
            int[] nS = queue.poll();
            if(graph[nS[0]][nS[1]]==-1) continue; // -1 썩은 토마토 건너뛰기

            for(int[] dir : dirs){
                int nX = nS[0] + dir[0];
                int nY = nS[1] + dir[1];
                if(nX >=0 && nY>=0 && nX<M && nY <N && graph[nX][nY]==0 && graph[nX][nY]!=-1){
                    if(graph[nS[0]][nS[1]]==-1) continue; // -1 썩은 토마토 건너뛰기
                    graph[nX][nY]=graph[nS[0]][nS[1]]+1;
                    //graph[nX][nY] = -2; // 방문 체크
                    queue.offer(new int[]{nX,nY});
                    cnt = graph[nX][nY]-1;
                }
            }
        }
    }
}

