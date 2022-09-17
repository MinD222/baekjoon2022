package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점



    }

    public void Bfs(){

    }
}
