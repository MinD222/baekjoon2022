package com.code.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1697. 숨바꼭질
public class BfsMain3 {
    static int result;
    static int[] arr;
    static int path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N==M) { // 만약 수빈이와 동생의 위치가 같다면 이동할 필요가 없다.
            System.out.println("0"); // 이 부분에서 오답처리를 받았다. 예외의 경우를 항상 생각하자.
            return;
        }

        arr = new int[M+1];
        arr[N]=1;
        Queue queue = new LinkedList();
        queue.offer(N-1);
        queue.offer(N+1);
        queue.offer(N*2);
        //while (result==M){
        int i=1;
        while (!queue.isEmpty()){
            i++;
            result = Integer.parseInt(queue.poll().toString());
            //arr[result]=arr[result]+1;
            if(arr[M]!=0){
                break;
            }
            //if(result >0 && result < M) {
                if (arr[result - 1] == 0 && result-1 > 0 ) {
                    arr[result-1] = arr[result]+1;
                    queue.offer(result - 1);
                }
                if (arr[result + 1] == 0 && result+1 >= M) {
                    arr[result+1] = arr[result]+1;
                    queue.offer(result + 1);
                }
                if (result*2 < M && arr[result * 2] == 0) {
                    arr[result*2] = arr[result]+1;
                    queue.offer(result * 2);
                }
            //}
        }

        System.out.println(arr[M]+1);
    }
}
