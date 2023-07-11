package com.itskb.codingtest.day07;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class B17608_막대기_최예빈 {

    static int N;
    static int highest, temp, count;
    static Stack<Integer> h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        h = new Stack<>();
        for (int i = 0; i < N; i++) {
            h.push(Integer.parseInt(br.readLine()));
        }

        highest = h.peek();
        count++;

        while (!h.isEmpty()) {
            temp = h.pop();
            if (highest < temp) {
                highest = temp;
                count++;
            }
        }

        System.out.println(count);
    }
}
