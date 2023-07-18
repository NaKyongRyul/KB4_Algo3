package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_조승빈 {
    static int N;
    static int M;
    static int cnt;

    static List<Integer>[] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            board[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            board[firstNode].add(secondNode);
            board[secondNode].add(firstNode);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int nxt : board[start]) {
            if (!visited[nxt]) {
                dfs(nxt);
            }
        }
    }
}
