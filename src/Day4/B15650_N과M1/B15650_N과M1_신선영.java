package day4;

import java.util.Scanner;

public class B15650_N과M1_신선영 {
    static int[] arr;
    static int M;
    static int[] ans;
    static boolean[] visited;

    static void combination(int r, int start) {
        if (r == M) {
            for (int a : ans) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) continue;

            ans[r] = arr[i];
            visited[i] = true;
            combination(r + 1, i + 1);
            visited[i] = false;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();

        ans = new int[M];
        visited = new boolean[N];

        arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }

        combination(0, 0);
    }
}
