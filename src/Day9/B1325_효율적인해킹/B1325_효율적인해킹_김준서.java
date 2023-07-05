package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1325_효율적인해킹_김준서 {
    static int max,N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] canHack;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        canHack = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(t).add(f);
        }
        for (int i = 1; i < N+1; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }
        for (int i = 1; i < N + 1; i++) {
            if (canHack[i] == max) {
                System.out.print(i+" ");
            }
        }
    }

    public static void bfs(int node) {
        int cur = 1;
        Queue<Integer> stack = new LinkedList<>();
        stack.add(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int temp = stack.poll();
            for (int adj : graph.get(temp)) {
                if (!visited[adj]) {
                    cur++;
                    stack.add(adj);
                    visited[adj]=true;
                }
            }
        }
        max = Math.max(max, cur);
        canHack[node] = cur;
    }
}