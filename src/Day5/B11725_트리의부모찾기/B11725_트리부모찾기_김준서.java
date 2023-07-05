package Day5.B11725_트리의부모찾기;


import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리부모찾기_김준서  {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            tree[f].add(t);
            tree[t].add(f);
        }
        travel(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void travel(int n) {
        for (int node : tree[n]) {
            if (!visited[node]) {
                parent[node] = n;
                visited[node]=true;
                travel(node);
            }
        }
    }

}
