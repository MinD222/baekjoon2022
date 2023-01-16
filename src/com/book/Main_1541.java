package com.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine() , "-");
        //1+2+3-4+5+6
        String[] arr = br.readLine().split("-");
        //55-50+40

        // 빼기 기준 모둠
        int res = 0;
        for(int i=0;i<arr.length;i++){
            String[] arr2 = arr[i].split("\\+");

            // 더하기 기준 모둠
            int sum=0;
            for(int j=0;j< arr2.length;j++){
                sum += Integer.parseInt(arr2[j]);
            }

            if(i==0) {
                res += sum;
            }else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
