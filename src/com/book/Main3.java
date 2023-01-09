package com.book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1260   BFS와 DFS
public class Main3 {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited=new boolean[1001];	//입력 케이스 +1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y]=1;
            graph[y][x]=1;
        }
        dfs(V);
        bfs(V);
    }
    static void dfs(int V){
        visited[V]=true;
        for(int i=0;i<N;i++){
            if(!visited[i]){

            }
        }

    }
    static void bfs(int V){

    }
}
