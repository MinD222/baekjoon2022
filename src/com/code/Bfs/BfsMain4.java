package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2178. 미로탐색
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
    static Queue queue = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 만들기(인접행렬)
        for(int i=0;i<N;i++){
            String line = st.nextToken();
            for(int j=0;j<M;j++){
                graph[i][j]=line.charAt(i)-'0';
            }
        }

        bfs();
    }

    static void bfs(){


    }
}
