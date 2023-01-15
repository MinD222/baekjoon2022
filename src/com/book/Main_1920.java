package com.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
    static int N,M;
    static int[] arrN;
    static int[] arrM;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        result = new int[M+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        int n = arrN[N/2-1];
        binary(n);
        for(int r : result){
            System.out.println(r);
        }
    }
    static void binary(int n){
        for(int i=0;i<M;i++){
            int m = arrM[i];

            if(arrN[n]>m){
                for(int j=0;j<n;j++){
                    if(m==arrN[j]){
                        result[i]=1;
                    }else{
                        continue;
                    }
                }
            }else{
                for(int k=n;k<M;k++){
                    if(m==arrN[k]) {
                        result[i]=1;
                    }else{
                        continue;
                    }
                }
            }

        }
    }
}
