package com.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr=new int[M+1];
        for(int i=0;i<M;i++){
            arr[i+1]=i+1;
        }
        arr[0] = arr[1] = 0;
        for(int i=2;i<=M;i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<=M;j+=i){
                arr[j]=0;
            }
        }

        for(int n:arr){
            if(n!=0 && n >= N){
                System.out.println(n);
            }
        }
    }
}
