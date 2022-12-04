package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsMain3 {
    static int result;
    static int[] arr;
    static int path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        arr[N]=1;
        Queue queue = new LinkedList();
        queue.offer(N-1);
        queue.offer(N+1);
        queue.offer(N*2);
        //while (result==M){
        for(int i=1;i<= queue.size();i++){
            result = Integer.parseInt(queue.poll().toString());
            arr[result]=i;
            if(arr[M]!=0){
                break;
            }
            if(result >0 && result < M) {
                if (arr[result - 1] == 0 && result-1 > 0 ) {
                    arr[result-1] = i;
                    queue.offer(result - 1);
                }
                if (arr[result + 1] == 0 && result+1 > M) {
                    arr[result+1] = i;
                    queue.offer(result + 1);
                }
                if (result*2 < M && arr[result * 2] == 0) {
                    arr[result*2] = i;
                    queue.offer(result * 2);
                }
            }
        }

        System.out.println(arr[M]);
    }
}
