package com.book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1260   BFS와 DFS
public class Main3 {
    static int N, M, V;
    static int[][] graph; // 인접행렬
    static boolean[] visited=new boolean[1001];	//입력 케이스 +1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y]=1;
            graph[y][x]=1;
        }
        dfs(V);
        visited=new boolean[1001];	// 재사용을 위한 초기화
        System.out.println(); // 개행
        bfs(V);

    }
    static void dfs(int V){
        visited[V]=true; //방문체크
        System.out.print(V + " ");
        for(int i=1;i<=N;i++){
            if(graph[V][i] == 1 &&!visited[i]){//방문하지않은 곳 재방문
                visited[i]=true;
                dfs(i);
            }
        }

    }
    static void bfs(int V){
        visited[V]=true; //방문체크
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
       // System.out.print(V + " ");
        while (!queue.isEmpty()){
            int nextV = queue.poll();
            System.out.print(nextV + " ");
            for(int i=1;i<=N;i++) {
                if (graph[nextV][i] == 1 && !visited[i]) {
                    visited[i] = true; //방문체크
                    queue.offer(i);

                }
            }
        }
    }
}
