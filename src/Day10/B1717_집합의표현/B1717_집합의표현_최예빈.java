package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합 0~n => n+1개
 * 0 a b 합집합
 * 1 a b 같은 집합 여부
 */
public class B1717_집합의표현_최예빈 {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (oper == 0) union(a, b);
            else sb.append((isUnion(a, b)) ? "YES" : "NO").append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean isUnion(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        return pa == pb;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
