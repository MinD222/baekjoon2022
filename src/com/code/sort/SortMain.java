package com.code.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 *
 * 5
 * 3 4
 * 1 1
 * 1 -1
 * 2 2
 * 3 3
 *
 * 버블정렬 계수정렬 이런게 아니었군..
 * Arrays.sort 를 쓰면 되는거여따
 *
 */
public class SortMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];
        for(int i=0; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(xy, (x,y)-> {
            if(x[0]==y[0]) return x[1] - y[1];
            else return x[0] - y[0];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< n ; i++) {
            sb.append(xy[i][0] + " " + xy[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
