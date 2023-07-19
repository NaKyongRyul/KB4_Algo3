package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023_ABCDE_조승빈 {
    static int N;
    static int M;
    static int flag = 0;

    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            tree[firstNode].add(secondNode);
            tree[secondNode].add(firstNode);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (flag == 1) break;
        }
        System.out.print(flag);
    }

    private static void dfs(int start, int depth) {
        if (depth == 4) {
            flag = 1;
            return;
        }

        visited[start] = true;
        for (int nxt : tree[start]) {
            if (visited[nxt]) continue;
            dfs(nxt, depth + 1);
        }
        visited[start] = false;
    }
}
