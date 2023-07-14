package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2961_도영이가만든맛있는음식_최예빈 {

    static int N;
    static long[] S, B;
    static boolean[] visited;
    static long taste = 2_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new long[N];
        B = new long[N];
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            S[i] = Long.parseLong(strings[0]);
            B[i] = Long.parseLong(strings[1]);
        }

        visited = new boolean[N];
        subset(0);

        System.out.println(taste);
    }

    // 부분 집합 //
    private static void subset(int idx) {
        if (idx == N) {
            long sour = 1;
            long bitter = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sour *= S[i];
                    bitter += B[i];
                }
            }
            if (bitter != 0) taste = Math.min(Math.abs(sour - bitter), taste);  // 적어도 한 개 선택
            return;
        }

        // 재귀 확장 //

        // 1) 선택하는 경우
        visited[idx] = true;
        subset(idx + 1);

        // 2) 선택하지 않는 경우
        visited[idx] = false;
        subset(idx + 1);
    }
}
