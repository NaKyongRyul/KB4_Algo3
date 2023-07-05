package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];



        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());

            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());
            int ans = arr[endI][endJ] - arr[startI-1][endJ] - arr[endI][startJ-1] + arr[startI-1][startJ-1];
            System.out.println(ans);
        }
    }
}
