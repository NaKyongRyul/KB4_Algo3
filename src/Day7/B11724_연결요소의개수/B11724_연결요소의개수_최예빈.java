package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_최예빈 {

    static int N, M;
    static List<Integer>[] graph;
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                ++count;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = count;

        for (Integer next : graph[node]) {

            if (visited[next] != 0) continue;

            dfs(next);
        }
    }
}
