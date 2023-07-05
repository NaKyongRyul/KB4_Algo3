package Day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


class Edge {

    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}

public class B1197_최소스패닝트리_김원우 {

    static int v;
    static int e;
    static Edge [] edges;

    static int [] parent;
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            int tmp3 = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(tmp1, tmp2, tmp3);
        }

        Arrays.sort(edges, (o1, o2) -> {
            return o1.cost - o2.cost;
        });

        int ans = 0;

        for (int i = 0; i < e; i++) {
            if (find(edges[i].start) == find(edges[i].end)) continue;

            union(edges[i].start, edges[i].end);
            ans += edges[i].cost;
        }
        System.out.println(ans);
    }
}
