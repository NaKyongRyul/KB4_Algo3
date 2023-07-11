package com.itskb.codingtest.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_최예빈 {

    static int N;
    static int queueSize;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) queue.offer(i);

        queueSize = queue.size();
        while (queueSize > 2) {
            queue.poll();
            queue.offer(queue.poll());
            queueSize--;
        }

        if (queueSize == 2) queue.poll();
        System.out.println(queue.peek());
    }
}
