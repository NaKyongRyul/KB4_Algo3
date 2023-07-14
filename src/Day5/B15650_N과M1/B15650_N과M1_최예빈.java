package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_최예빈 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(str[0]);   // 수의 범위
        M = Integer.parseInt(str[1]);   // 자리수

        boolean[] visited = new boolean[N + 1];

        combination(sb, visited, 0, 0);
    }

    private static void combination(StringBuilder sb, boolean[] visited, int idx, int depth) {
        if (depth == M) {
            System.out.println(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = idx + 1; i < N + 1; i++) {
            if (visited[i]) continue;

            // 선택 //
            visited[i] = true;
            sb.append(i).append(" ");
            combination(sb, visited, i, depth + 1);

            // 선택 해제 //
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
