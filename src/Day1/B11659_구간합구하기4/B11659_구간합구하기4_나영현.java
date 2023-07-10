package Day1.B11659_구간합구하기4;

import java.util.Scanner;

public class B11659_구간합구하기4_나영현 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] arr = new int[N+1];

    for(int i =1; i<N+1; i++) {
      arr[i] = arr[i-1] + sc.nextInt();
    }

    for (int i = 0; i < M; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();

      int answer = arr[end] - arr[start-1];

      System.out.println(answer);
    }
  }
}
