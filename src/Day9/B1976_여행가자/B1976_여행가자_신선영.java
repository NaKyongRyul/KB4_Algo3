package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_신선영 {
    static int N;
    static int M;
    static int[] connection;

    static int find(int x) {
        if (connection[x] == x) return x;
        else return connection[x] = find(connection[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) connection[y] = x;
        else connection[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 도시의 수 (<=200)
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 계획에 속한 도시 수

        connection = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            connection[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int c = Integer.parseInt(st.nextToken());
                // 연결된 부모 노드 모두 통일
                if (c == 1) union(i, j);
            }
        }

        String ans = "YES";
        String[] map = br.readLine().split(" ");
        for (int i = 1; i < M; i++) {
            if (find(Integer.parseInt(map[i])) != find(Integer.parseInt(map[i - 1]))) {
                // 연결되지 않은 노드 경로에 포함 시 답 변경 후 break
                ans = "NO";
                break;
            }
        }

        System.out.println(ans);
    }
}
