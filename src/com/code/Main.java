package com.code;


import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int pushNum = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            if(method.contains("push")) {
                pushNum = Integer.parseInt(st.nextToken());
            }
            int r = -1;
            switch (method){
                case "push":
                    queue.add(pushNum);
                    break;
                case "pop":
                    if(!queue.isEmpty()){ r =  queue.poll();}
                    sb.append(r+"\n");
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) {sb.append(0+"\n");}
                    else {sb.append(0+"\n");}
                    break;
                case "front":
                    if(!queue.isEmpty()) {r =  queue.peek();}
                    sb.append(r+"\n");
                    break;
                case "back":
                    sb.append(pushNum+"\n");
                    break;
            }

        }
        System.out.println(sb);
        br.close();
    }
}
