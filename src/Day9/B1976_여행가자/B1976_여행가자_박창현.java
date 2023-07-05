package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_박창현 {
    static int[] parent;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
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
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] check = new int[M];
        StringTokenizer st;
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) union(i, j);
            }
        }
        st = new StringTokenizer(bf.readLine());
        boolean flag = false;
        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 1; i < M; i++) {
            if (find(check[i]) != find(check[i - 1])) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "NO" : "YES");
//        System.out.println(Arrays.toString(check));
//        for (int i : check) {
//            System.out.println(find(i));
//        }
    }
}
