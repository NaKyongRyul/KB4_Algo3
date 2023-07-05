package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_김준서 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(bf.readLine(), " ");
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                int temp=Integer.parseInt(token.nextToken());
                arr[i][j]=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1]+temp;
            }
        }

        for (int i=0;i<M;i++) {
            int answer = 0;
            token = new StringTokenizer(bf.readLine(), " ");
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            answer += arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
            System.out.println(answer);
        }


    }
}
