package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B13023_ABCDE_최예빈 {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
//            System.out.println("--- " + i);
            visited[i] = true;
            if (find5th(i, 1)) {
                System.out.println(1);
                System.exit(0);
            }
            visited[i] = false;
        }
        System.out.println(0);
    }

    private static boolean find5th(int n, int th) {
//        System.out.println(Arrays.toString(visited));
        if (th == 5) {
            return true;
        }

        for (Integer next : graph[n]) {
            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            boolean found = find5th(next, th + 1);
            if (found) return true;

            visited[next] = false;
        }

        return false;
    }
}
