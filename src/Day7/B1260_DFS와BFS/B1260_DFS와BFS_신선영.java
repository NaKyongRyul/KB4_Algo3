package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_신선영 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (Integer g : graph[v]) {
            if (!visited[g]) DFS(g);
        }
    }

    static void BFS(int v) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(v);     // 시작 정점 넣고 시작
        visited[v] = true;

        while (!que.isEmpty()) {    // 큐에 값이 남아있는 한 반복
            int node = que.poll();
            System.out.print(node + " ");
            ArrayList<Integer> now = graph[node];
            for (Integer n : now) {
                if (!visited[n]) que.add(n);
                visited[n] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점 번호: 1 ~ N

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수

        int V = Integer.parseInt(st.nextToken());   // 탐색 시작 정점 번호

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];   // 트리 아닌 그래프 -> visited 체크

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
            Collections.sort(graph[i]);
        }

        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }
}
