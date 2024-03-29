package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 문제
 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

 입력
 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

 출력
 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
public class BfsMain2 {
    static int V, E, R, cnt;
    static boolean[] visited;
    //static int[] resultBfs;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트
    static StringBuilder resultBfs = new StringBuilder();
    static StringBuilder resultDfs = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken()); // 정점의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[V+1];
       // resultBfs = new int[V+1];

        for(int i=0;i<V+1;i++){
            graph.add(new ArrayList<>());
        }

        // 그래프 생성
        for(int i=0;i<E;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int x =  Integer.parseInt(st2.nextToken());
            int y =  Integer.parseInt(st2.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=0;i< graph.size();i++){
            Collections.sort(graph.get(i));
        }
        bfs(R);
        visited = new boolean[V+1];
        dfs(R);
        System.out.println(resultDfs);
        System.out.println(resultBfs);
    }
    static void dfs(int R){
        visited[R]=true;
        resultDfs.append(R+" ");
        for(int nextR:graph.get(R)){
            if(!visited[nextR]){
                visited[nextR]=true;
                dfs(nextR);
            }
        }
    }
    static void bfs(int R){
        Queue<Integer> queue = new LinkedList<>();
        visited[R]=true;
        queue.offer(R);
        while (queue.size()!=0){
            R = queue.poll();
            resultBfs.append(R+" ");
            for(int nextR : graph.get(R)){
                if(!visited[nextR]){
                    visited[nextR]=true;
                    queue.offer(nextR);
                }
            }
        }
    }
}
