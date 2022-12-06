package com.code.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */
public class DfsMain2 {

    static int V;
    static int[][] graph;
    static int count = 0;
    static ArrayList<Integer> result =new ArrayList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] dirX={0,0,1,-1};// 좌우
    static int[] dirY={1,-1,0,0};// 상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new int[V][V];
        visited = new boolean[V][V];

        // 인접 행렬 그래프
        for(int i=0;i<V;i++){
            String line = br.readLine();
            for(int j=0;j<V;j++){
                graph[i][j]=line.charAt(j)-'0';
            }
        }

        // 정사각형 크기만큼 탐색
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(!visited[i][j] && graph[i][j]==1){
                    count=1;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }

        //sb.append(count);
        Collections.sort(result);
        System.out.println(result.size());
        for(int n:result){
            System.out.println(n);
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nowX = dirX[i] + x;
            int nowY = dirY[i] + y;
            if(nowX >= 0 && nowX < V && nowY >= 0 && nowY < V && visited[nowX][nowY] == false && graph[nowX][nowY] == 1){
                visited[nowX][nowY]=true;
                count++;
                dfs(nowX, nowY);

            }
        }
    }
}
