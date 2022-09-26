package com.code.Queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*

10 3
1 2 3

0
 */
public class DequeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList();
        int num = 0;
        int[] arr = new int[M];
        for(int i=1;i<=N;i++){
            dq.offer(i); // 1 2 3 4 5 6 7 8 9 10
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++){
            arr[i] = Integer.parseInt(st2.nextToken());//[2,9,5]
        }

        // poll M번
        for(int i=0;i<M;i++){
            // 1, 2, 3 ,, 이 나올때까지 큐 정리하기
            while (dq.peek()!=arr[i]){
                if(arr[i] < dq.size()/2){

                }

            }
            // 1, 2, 3,,, 이 나오면 poll!
        }

    }
}
