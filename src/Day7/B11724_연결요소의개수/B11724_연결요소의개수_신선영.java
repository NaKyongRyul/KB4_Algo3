package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_신선영 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void DFS(int v) {
        visited[v] = true;

        ArrayList<Integer> node = graph[v];
        for (int n : node) {
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int ans = 0;

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            // 방문하지 않은 노드를 찾으면 시작점
            // 해당 시작점에서 DFS를 통해 연결지점은 모두 visited 처리
            // 시작점의 수 count
            if (!visited[i]) {
                ans++;
                DFS(i);
            }
        }

        System.out.println(ans);
    }
}
