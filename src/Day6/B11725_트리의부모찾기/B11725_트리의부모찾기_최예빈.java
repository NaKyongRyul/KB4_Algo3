package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  11725	맞았습니다!!	74360	1352	Java 11 
 */
public class B11725_트리의부모찾기_최예빈 {

    static List<List<Integer>> graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.println(graph.get(i));
        }

        parent = new int[n + 1];
        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }

    }

    static void dfs(int root) {
            for (Integer next : graph.get(root)) {
            if (parent[next] == 0) {
                parent[next] = root;
                dfs(next);
            }
        }
    }
}
