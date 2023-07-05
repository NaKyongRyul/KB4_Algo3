package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_임재현 {
    static int N, M, V;
    static boolean[][] G;
    static boolean[][] visited;
    static StringBuilder builder = new StringBuilder();

    static void dfs(int node) {
        for (int i = 1; i <= N; i++) {
            if (G[node][i] && !visited[i][0]) {
                visited[i][0] = true;
                builder.append(i + " ");
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        visited[V][1] = true;
        builder.append(start + " ");

        while (q.size() > 0) {
            int front = q.poll();
            for (int i = 1; i <= N; i++) {
                if (G[front][i] && !visited[i][1]) {
                    visited[i][1] = true;
                    builder.append(i + " ");
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());
        G = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][2];

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(token.nextToken());
            int v2 = Integer.parseInt(token.nextToken());
            G[v1][v2] = true;
            G[v2][v1] = true;
        }
        builder.setLength(0);
        visited[V][0] = true;
        builder.append(V + " ");
        dfs(V);
        System.out.println(builder);

        builder.setLength(0);
        bfs(V);
        System.out.println(builder);
    }
}
