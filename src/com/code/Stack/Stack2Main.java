package com.code.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack2Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int r = Integer.parseInt(br.readLine());
            if(r == 0) stack.pop();
            else stack.push(r);
        }
        int sum = 0;
        int size = stack.size();
        for(int i=0; i<size ; i++){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
