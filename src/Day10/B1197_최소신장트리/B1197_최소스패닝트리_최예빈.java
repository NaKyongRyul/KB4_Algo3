package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B1197_최소스패닝트리_최예빈 {

    static int V, E;                //V: 정점, E: 간선
    static List<Connect> connects;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 간선 정보
        connects = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            connects.add(new Connect(u, v, w));
        }
        
        // 정렬
        connects.sort(Comparator.comparingInt(o -> o.w));

        // 집합 
        parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        // 가중치가 가장 적은 것을 선택하여 트리 확장 
        int wSum = 0;
        for (int i = 0; i < E; i++) {
            int u = connects.get(i).u;
            int v = connects.get(i).v;

            if (!isUnion(u, v)) {
                union(u, v);
                wSum += connects.get(i).w;
            }
        }

        System.out.println(wSum);
    }

    private static boolean isUnion(int u, int v) {
        return find(u) == find(v);
    }

    private static int find(int u) {
        if (parent[u] == u) return u;
        else return parent[u] = find(parent[u]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u < v) parent[v] = u;
        else parent[u] = v;
    }

    private static class Connect {
        int u, v, w;

        public Connect(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
