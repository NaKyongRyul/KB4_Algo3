package com.itskb.codingtest.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_최예빈 {

    static int n;
    static int index, anInt, stackSize;
    static int temp, top;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        index = 0; // arr 의 인덱스
        anInt = 1; // 스택에 넣을 숫자
        stack.push(anInt++);
        stackSize++;
        sb.append("+").append("\n");

        while (index < n) {
            if (stackSize == 0) {
                stack.push(anInt++);
                stackSize++;
                sb.append("+").append("\n");
            } else {
                top = stack.peek();
                temp = arr[index];
                if (top == temp) {
                    stack.pop();
                    stackSize--;
                    sb.append("-").append("\n");
                    index++;
                } else if (anInt <= n) {
                    stack.push(anInt++);
                    stackSize++;
                    sb.append("+").append("\n");
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        System.out.println(sb);
    }
}
