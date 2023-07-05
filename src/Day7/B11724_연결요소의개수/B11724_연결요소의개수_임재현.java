package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_임재현 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int ans;

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        visited[start] = true;
        while (q.size() > 0) {
            int front = q.poll();
            for (int i = 0; i < adj[front].size(); i++) {
                int target = adj[front].get(i);
                if (visited[target])
                    continue;
                q.add(target);
                visited[target] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                ans++;
                bfs(i);
            }
        }

        System.out.println(ans);
    }
}
