package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_조승빈 {
    static int N;
    static int M;

    static boolean[] visited;
    static int[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        select = new int[M + 1];

        combination(1, 0);
    }

    private static void combination(int idx, int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                if (i != M) {
                    System.out.print(select[i] + " ");
                } else {
                    System.out.println(select[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            select[size] = i;
            combination(i, size + 1);
            visited[i] = false;
        }
    }
}
