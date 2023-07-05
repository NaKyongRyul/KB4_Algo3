package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(token.nextToken()); // 수의 개수
		int m = Integer.parseInt(token.nextToken()); // 합을 구해야하는 개수
		int[][] arr = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			for(int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
			}
		}
		
		for(int i = 0; i < m; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			int ans = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
			System.out.println(ans);
		}
	}
}

