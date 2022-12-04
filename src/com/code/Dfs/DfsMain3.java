package com.code.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 1
 10 8 17
 0 0
 1 0
 1 1
 4 2
 4 3
 4 5
 2 4
 3 4
 7 4
 8 4
 9 4
 7 5
 8 5
 9 5
 7 6
 8 6
 9 6
 */
public class DfsMain3 {
    static int N;
    static int M;
    static int L;
    static int[][] graph;
    static List<int[][]> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static int count;
    static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for(int i=0;i<C;i++){
            N=0;
            M=0;
            L=0;
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            graph = new int[N][M]; // 0으로 사각형 세팅
            for(int j=0;j<L;j++){

                st= new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y]=1; // 연결된 노드만 1로 표시(배추)
            }
            list.add(graph);
            //dfs_solve(N,M,graph);
            // 사각형 크기만큼 탐색
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    if(graph[x][y]==1){
                        count++;
                        dfs(x,y);

                    }
                }
            }
            result.add(count);
            count=0;
            graph = new int[N][M]; // 다음 그래프를 위해 초기화
        }

        for(int r : result){
            System.out.println(r);
        }

    }

/*
    static void dfs_solve(int N, int M, int[][] graph){
        // 사각형 크기만큼 탐색
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j]==1){
                    dfs(i,j);
                }
            }
        }
    }
*/

    static void dfs(int x, int y){
        if(x<0 || x>=N || y<0 || y>=M || graph[x][y]==0)
            return ;
        graph[x][y]=0;
        for(int[] dir:dirs){
            int nX= x +dir[0];
            int nY= y +dir[1];
            dfs(nX,nY);
        }
    }
}
