package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합5_나영현 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cnt = 0;
    int end = 0;

    int prefix_sum = 0;

    for (int start = 1; start <= N; start++) {
      while (prefix_sum < N && end <= N) {
        prefix_sum += end;
        end += 1;
      }
      if (prefix_sum == N) {
        cnt += 1;
      }
      prefix_sum -= start;
    }
    int answer = cnt;
    System.out.println(answer);
  }
}