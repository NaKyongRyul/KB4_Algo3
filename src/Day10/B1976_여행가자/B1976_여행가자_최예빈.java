package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_최예빈 {

    static int N, M;    // 도시 N개, 여행 계획 M개
    static int[][] matrix;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

//        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (matrix[i][j] == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken()) - 1;
            if (!isUnion(start, next)) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    private static boolean isUnion(int a, int b) {
        return find(a) == find(b);
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
