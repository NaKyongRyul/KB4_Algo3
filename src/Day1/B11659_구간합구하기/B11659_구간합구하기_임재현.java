package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_임재현 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        long[] sum = new long[N + 1];
        sum[0] = 0;
        int M = Integer.parseInt(token.nextToken());
    
        token = new StringTokenizer(bf.readLine());
        for (int _i = 1; _i <= N; _i++) {
            sum[_i] = sum[_i - 1] + Integer.parseInt(token.nextToken());
        }

        for (int _i = 0; _i < M; _i++) {
            token = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            System.out.println(sum[y] - sum[x - 1]);
        }
    }
}
