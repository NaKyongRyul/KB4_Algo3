package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_임재현 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] sum = new int[N + 1][N + 1];

        for (int _i = 0; _i <= N; _i++) {
            sum[_i][0] = 0;
            sum[0][_i] = 0;
        }

        // sum[x][y] = k + sum[x - 1][y] + sum[x][y - 1] - sum[x - 1][y - 1]
        for (int _i = 1; _i <= N; _i++) {
            token = new StringTokenizer(bf.readLine());
            for (int _j = 1; _j <= N; _j++) {
                int k = Integer.parseInt(token.nextToken());
                sum[_i][_j] = k + sum[_i - 1][_j] + sum[_i][_j - 1] - sum[_i - 1][_j - 1];
            }
        }

        // ans = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]
        for (int _i = 0; _i < M; _i++) {
            token = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            System.out
                    .println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
        }

    }
}
