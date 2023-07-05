package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_신선영 {
    static int N;
    static int M;
    static int[] parents;

    static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 더 작은 숫자를 부모로 지정
        if (x < y) parents[y] = x;
        else parents[x] = y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N + 1개의 집합
        M = Integer.parseInt(st.nextToken());   // 연산의 개수

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i; // 모두 루트인 상태로 시작
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) {   // union
                union(b, c);
            } else {    // find
                if (find(b) == find(c)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
