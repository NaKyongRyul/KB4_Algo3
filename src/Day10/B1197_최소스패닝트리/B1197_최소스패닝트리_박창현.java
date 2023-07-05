package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1197_최소스패닝트리_박창현 {
    static int[] parent;

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" + "start=" + start + ", end=" + end + ", weight=" + weight + '}';
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, w);
        }
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));
//        System.out.println(Arrays.toString(edges));

        int result = 0;

        for (int i = 0; i < E; i++) {
            if (find(edges[i].start) == find(edges[i].end)) continue;
            union(edges[i].start, edges[i].end);
            result += edges[i].weight;
        }
//        System.out.println(Arrays.toString(edges));
        System.out.println(result);
    }
}
