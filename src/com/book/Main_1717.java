package com.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1717 집합의 표현
public class Main_1717 {
    static int N,M;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        for(int i=0;i<N;i++){
            parents[i]=i;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(s==0){
                union(x, y);
            }else{
                isSameParents(x, y);
            }
        }

        System.out.println(sb);
    }

    // x 의 root node 를 찾음
    static int find(int x){
        if(x==parents[x]) return x;
        return parents[x]=find(parents[x]);
    }

    static void union(int x, int y){
        int x1 = find(x);
        int y1 = find(y);
        if(x1!=y1) {
            if(x1 <y1) parents[y1] = x1;
            else parents[x1] = y1;
        }
    }

    static void isSameParents(int x, int y){
        int x1 = find(x);
        int y1 = find(y);
        if(x1==y1) sb.append("YES\n");
        else sb.append("NO\n");
    }
}
