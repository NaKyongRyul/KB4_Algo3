package Day9.B1976_여행가자;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1976_여행가자_김준서 {
    static int M,N;
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    union(i+1, j+1);
                }
            }
        }
        st = new StringTokenizer(bf.readLine());
        int temp = parent[Integer.parseInt(st.nextToken())];
        for (int i = 1; i < M; i++) {
            if (temp != parent[Integer.parseInt(st.nextToken())]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        int temp = findParent(a);
        a = temp;
        temp = findParent(b);
        b = temp;
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
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