package com.book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724   연결요소의 개수
public class Main2 {
    static int N, M,cnt;
    static int[][] graph=new int[1001][1001]; // 인접행렬
    static boolean[] visited= new boolean[1001];// 방문체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선

        for(int i=0;i<M;i++) { // 간선으로 연결 그래프 만들기
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y]=graph[y][x]=1;
        }
        dfs(1);
        if(M==0){
            System.out.println(1);
        }else{
            System.out.println(cnt);
        }

    }

    static void dfs(int n){
        if(!visited[n]){
            cnt++;
        }
        visited[n]=true;
        for(int i=1;i<=N;i++) {
            if(!visited[i]&&graph[i][n]==1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
