package com.company;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    while (true) {
      if (queue.size() == 1) {
        break;
      }
      queue.poll();
      int top = queue.poll();
      queue.add(top);
    }
    int answer = queue.peek();
    System.out.println(answer);
  }
}
