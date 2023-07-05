package Day9.B1717_집합의_표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

public class B1717_집합의_표현_김준서 {
    static int M,N;
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (opt == 0) {
                union(a, b);
            } else {
                a = findParent(a);
                b = findParent(b);
                if (a == b) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
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