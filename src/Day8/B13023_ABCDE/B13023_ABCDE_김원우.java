package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B13023_ABCDE_김원우 {

    static int n,m;
    static LinkedList<Integer> [] graph;

    static boolean [] visited;
    static int flag = 0;
    static void dfs(int num, int cnt) {
        visited[num] = true;
        if (cnt >= 4) {
            flag = 1;
            return;
        }

        for (int i : graph[num]) {
            if (visited[i]) continue;
            dfs(i, cnt+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            graph[tmp1].add(tmp2);
            graph[tmp2].add(tmp1);
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
            if (flag == 1) break;
        }
        System.out.println(flag);
    }
}
