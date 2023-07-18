package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_최예빈 {

    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");

        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);
        V = Integer.parseInt(strings[2]);

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            strings = br.readLine().split(" ");
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        dfs(V, sb);

        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V, sb);

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dfs(int node, StringBuilder sb) {

        visited[node] = true;
        sb.append(node).append(" ");

        for (Integer next : graph[node]) {

            if (visited[next]) continue;

            dfs(next, sb);
        }
    }

    private static void bfs(int node, StringBuilder sb) {

        Queue<Integer> queue = new ArrayDeque<>();

        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            sb.append(temp).append(" ");

            for (Integer next : graph[temp]) {
                if (visited[next]) continue;

                visited[next] = true;
                queue.add(next);
            }
        }

    }
}
