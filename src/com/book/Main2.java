package com.book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724   연결요소의 개수
public class Main2 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선

        for(int i=0;i<M;i++) { // 간선으로 연결 그래프 만들기
            st = new StringTokenizer(br.readLine()," ");

        }
    }
}
