package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_송봉섭 {
    static int N;
    static int M;
    static int[] parents;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        // 배열 초기화
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (flag == 0) {
                //union
                union(x,y);
            } else if (flag == 1) {
                //find
                if (find(x) == find(y)) {
                    //System.out.println("YES");
                    sb.append("YES");
                    sb.append("\n");
                }
                else {
                    //System.out.println("NO");
                    sb.append("NO");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);

    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            if (x < y) {
                parents[y] = x;
            }
            else {
                parents[x] = y;
            }
        }
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
