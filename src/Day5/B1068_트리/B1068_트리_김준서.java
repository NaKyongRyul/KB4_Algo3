package Day5.B1068_트리;
import java.util.ArrayList;
import java.util.Scanner;

public class B1068_트리_김준서 {
    static int N,cnt=0,root=0;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp == -1) {
                root = i;
            } else {
                tree[temp].add(i);
            }
        }
        visited[sc.nextInt()]=true;
        if (visited[root]) {
            System.out.println(0);
            return;
        }
        visited[root]=true;
        travel(root);
        System.out.println(cnt);
    }

    public static void travel(int node) {
        boolean isLeaf=true;
        for (int adj : tree[node]) {
            if (!visited[adj]) {
                visited[adj]=true;
                travel(adj);
                isLeaf=false;
            }
        }
        if (isLeaf) {
            cnt++;
        }
    }


}
