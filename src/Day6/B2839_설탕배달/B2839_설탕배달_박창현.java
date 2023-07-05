package Day6.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2839_설탕배달_박창현 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int a = 3, b = 5;

        int[] arr = new int[N + 1];
        Arrays.fill(arr, 0);
        if (N >= a) arr[a] = 1;
        if (N >= b) arr[b] = 1;

        for (int i = Math.max(a, b); i < N + 1; i++) {
            if (arr[i - a] == 0 && arr[i - b] == 0) continue;
            if (arr[i - a] == 0) arr[i] = arr[i - b] + 1;
            else if (arr[i - b] == 0) arr[i] = arr[i - a] + 1;
            else arr[i] = Math.min(arr[i - a], arr[i - b]) + 1;
        }

        if (arr[N] == 0) System.out.println(-1);
        else System.out.println(arr[N]);
    }
}
