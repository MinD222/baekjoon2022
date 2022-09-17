package com.code.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class DfaMain {
    static int V, E, R, cnt;
    static boolean[] visited;
    static int[] seq;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken()); // 정점의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[V+1];
        seq = new int[V+1];

        // 1. 인접리스트 만들기
        //인접리스트 초기화
        for(int i=0;i<V+1;i++){
            graph.add(new ArrayList<>());
        }
        // 간선 수 만큼 인접 리스트 add (문제에서 입력받은 두 자리의 간선 수 만큼)
        for(int i=0;i<E;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int x =  Integer.parseInt(st2.nextToken());
            int y =  Integer.parseInt(st2.nextToken());
            //graph.add(graph.get(x).get(y));
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for(int i=0;i< graph.size();i++){
            Collections.sort(graph.get(i));
        }
        cnt =1;
        dfs(R);
        for(int i=1;i<seq.length;i++){
            System.out.println(seq[i]);
        }


    }

    public static void dfs(int R){
        // 해당 정점 방문 체크!
        visited[R] = true;
        seq[R] = cnt;
        //System.out.println(R + " "); // 해당 정점 출력
        // dfs
/*        for (int i = 0; i <= graph.get(R).size(); i++) {
            int nextR = graph.get(R).get(i); // 다음 탐색 정점 구하기
            if (!visited[nextR]) { // 다음 탐색할 정점에 방문한적이 없을 때만 다시 dfs 탐색
                seq[R] = nextR;
                dfs(nextR);
            }
        }*/
       for (int nextR : graph.get(R)) {
            if (!visited[nextR]) {
                cnt++;
                dfs(nextR);
            }
        }
    }
}
