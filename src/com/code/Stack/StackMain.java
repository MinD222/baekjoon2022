package com.code.Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여섯 가지이다.
 *정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 다섯 가지이다.
 *
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */


public class StackMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

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
                    stack.push(pushNum);
                    break;
                case "pop":
                    if(!stack.isEmpty())
                        r =  stack.pop();
                    sb.append(r+"\n");
                    break;
                case "size":
                    sb.append(stack.size()+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty())  sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "top":
                    if(!stack.isEmpty())
                        r =  stack.peek();
                    sb.append(r+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
