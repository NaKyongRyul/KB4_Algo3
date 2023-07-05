package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class B13023_ABCDE_김준서 {
    static Map<Integer, ArrayList<Integer>> graph;
    static boolean[] visited;
    static int N, M;
    static boolean terminated=false;

    public static void dfs(int start, int level) {
        if (terminated) {
            return;
        }
        if (level == 5) {
            System.out.println(1);
            terminated = true;
            return;
        }
        if (!graph.containsKey(start)) {
            return;
        }
        for (int adj : graph.get(start)) {
            if (!visited[adj]) {
                visited[adj]=true;
                dfs(adj, level + 1);
                visited[adj]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (graph.containsKey(f)) {
                graph.get(f).add(t);
            } else {
                graph.put(f, new ArrayList<>(Arrays.asList(t)));
            }
            if (graph.containsKey(t)) {
                graph.get(t).add(f);
            } else {
                graph.put(t, new ArrayList<>(Arrays.asList(f)));
            }
        }
        for (int i = 0; i < N; i++) {
            visited[i]=true;
            dfs(i, 1);
            visited[i]=false;
        }
        if (!terminated) {
            System.out.println(0);
        }
    }
}