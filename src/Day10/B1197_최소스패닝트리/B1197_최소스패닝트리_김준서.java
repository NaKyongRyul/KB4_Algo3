package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B1197_최소스패닝트리_김준서 {
    public static class Graph{
        public int f, t, cost;

        Graph(int f, int t, int cost) {
            this.f = f;
            this.t = t;
            this.cost = cost;
        }
    }
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int cur=0,answer=0;
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i]=i;
        }
        ArrayList<Graph> graph = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Graph(f, t, cost));
        }
        graph.sort((a,b)->a.cost-b.cost);
        for (Graph temp : graph) {
            int tt = temp.t;
            int tf = temp.f;
            int tcost = temp.cost;
            if (findParent(tt) != findParent(tf)) {
                union(tt, tf);
                cur++;
                answer += tcost;
                if (cur == V - 1) {
                    System.out.println(answer);
                }
            }

        }
    }
    public static void union(int a, int b) {
        int temp = findParent(a);
        a = temp;
        temp = findParent(b);
        b = temp;
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int findParent(int node) {
        int temp = parent[node];
        if (temp == node) {
            return temp;
        } else {
            parent[node] = findParent(temp);
        }
        return parent[node];
    }
}