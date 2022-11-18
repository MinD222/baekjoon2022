package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 오늘도 서준이는 너비 우선 탐색(BFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

 N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다. 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.

 너비 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.

 bfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
 for each v ∈ V - {R}
 visited[v] <- NO;
 visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
 enqueue(Q, R);  # 큐 맨 뒤에 시작 정점 R을 추가한다.
 while (Q ≠ ∅) {
 u <- dequeue(Q);  # 큐 맨 앞쪽의 요소를 삭제한다.
 for each v ∈ E(u)  # E(u) : 정점 u의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
 if (visited[v] = NO) then {
 visited[v] <- YES;  # 정점 v를 방문 했다고 표시한다.
 enqueue(Q, v);  # 큐 맨 뒤에 정점 v를 추가한다.
 }
 }
 }
 */

public class BfsMain {
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
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=0;i< graph.size();i++){
            Collections.sort(graph.get(i));
        }

        cnt =1;
        Queue<Integer> queue = new LinkedList<>();
        bfs(R, queue);

        for(int i=1;i<seq.length;i++){
            System.out.println(seq[i]);
        }
    }

    public static void bfs(int R,Queue<Integer> queue){
        visited[R] = true;
        seq[R] = cnt;
        queue.offer(R);
        // 큐 반복
        while (queue.size() != 0){
            R = queue.poll();
            // 그래프 반복
            for (int nextR : graph.get(R)) {
                if (!visited[nextR]) {
                    cnt++;
                    visited[nextR] = true;
                    seq[nextR] = cnt;
                    queue.offer(nextR);
                }
            }
        }
    }
}
