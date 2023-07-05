package day5;

import java.util.Arrays;
import java.util.Scanner;

public class B1182_부분수열의합_신선영 {
    static int N;
    static int S;
    static int R;
    static int[] arr;

    static int[] selected;
    static boolean[] visited;

    static int ans;

    static void combination(int r, int start) {
        if (r == R) {
            // 조합의 합이 주어진 수와 같은 경우 답에 ++
            if (Arrays.stream(selected).sum() == S) ans++;
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) continue;
            selected[r] = arr[i];
            visited[i] = true;
            combination(r + 1, i + 1);
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        // N이 20개 이하라 scanner로도 괜찮을듯?
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 정수의 개수
        S = sc.nextInt();   // 합이 되어야 하는 정수
        ans = 0;

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 수열(정렬된 상태)로 주어지므로 1개부터 N개까지의 조합 모두 확인
        for (int i = 1; i <= N; i++) {
            R = i;
            selected = new int[i];
            visited = new boolean[N];
            combination(0, 0);
        }

        System.out.println(ans);
    }
}
