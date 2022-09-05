package com.code.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue3Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        sb.append("<");
        //int[] arr = new int[n];
        for(int i=1; i <=n; i++){
            queue.offer(i);
        }

        int s = queue.size();
        int r = 0;
        for(int i=1; i<=queue.size(); i++){
            for(int j=0 ; j <k-1; j++){
                r = queue.poll();
            }
            //arr[i-1] = r;
            int next = queue.poll(); // 2 담기
            queue.offer(next);
        }
        System.out.println(sb);
    }
}
