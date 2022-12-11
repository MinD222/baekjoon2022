package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7562. 나이트의 이동 silver 1

public class BfsMain5 {
    static int[][] dirs = {{-1,2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};
    static int N;
    static int[] start;
    static int[] end;
    static int[] result;
    static int cnt;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];


        for(int i=0;i<N;i++){
            int G = Integer.parseInt(br.readLine());
            graph = new int[301][301];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            start = new int[]{x,y};

            graph[x][y]=1;
            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new int[]{x,y};

            bfs(start, end);
            result[i]=graph[x][y]-1;
            cnt=0;
        }

       for(int n : result){
            System.out.println(n);
        }
    }

    static void bfs(int[] start, int[] end){

        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
/*             if(Arrays.equals(poll,end)){
                    return;
             }*/
            if(end[0]==poll[0] && end[1]==poll[1]){
                queue.clear();
                return;
            }
            for (int[] dir : dirs) {
                int nX = poll[0] + dir[0];
                int nY = poll[1] + dir[1];
                //graph[poll[0]][poll[1]] = 1;
/*                if(Arrays.equals(new int[]{nX,nY},end)){
                    return;
                }*/
                if (nX >= 0 && nY >= 0 && nX <= 300 && nY <=300 && graph[nX][nY] == 0) {
                    graph[nX][nY] = graph[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{nX, nY});
                    //graph[nX][nY] = 1;
                    //cnt = graph[nX][nY];
                }
            }
        }

    }
}
