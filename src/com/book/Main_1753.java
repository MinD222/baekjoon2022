package com.book;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
    int edge, weight;

    public Node(int edge, int weight){
        this.edge=edge;
        this.weight=weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
// 1753 최단경로 다익스트라
public class Main_1753 {
    static int V,E,R;
    static ArrayList<Node>[] graph;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        result = new int[V+1];


        for(int i=0;i<=V;i++){
            graph[i]= new ArrayList<Node>();
        }

        Arrays.fill(result, Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // start 에서 end 로 가는 가중치(w)
            graph[start].add(new Node(end, w));
        }

        dist(R);

        // 5. 전체 출력
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else {
                sb.append(result[i]+"\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    static void dist(int r){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        result[r] =0;
        pq.add(new Node(r,0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : graph[now.edge]){
                if(result[next.edge] > now.weight + next.weight){
                    result[next.edge] = now.weight + next.weight;
                    pq.add(new Node(next.edge, result[next.edge]));
                }
            }


        }


    }
}
