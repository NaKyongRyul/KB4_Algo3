package com.company;

import java.util.Scanner;
import java.util.Stack;

public class B17608 {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      int next = sc.nextInt();

      if (stack.isEmpty()) {
        stack.push(next);
        cnt += 1;
      }

      else if (stack.peek() <= next) {
        stack.pop();
        stack.push(next);
        cnt += 1;
      }

      else {
        stack.push(next);
      }

    }

    System.out.println(cnt);

  }
}
