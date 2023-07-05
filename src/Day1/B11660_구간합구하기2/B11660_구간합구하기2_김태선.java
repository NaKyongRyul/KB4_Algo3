package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_김태선 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("배열의 크기, 질의의 개수 : ");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			
			System.out.println("원본 배열 : ");
			
			StringTokenizer value = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(value.nextToken());	
			}
		}
		
		int [] [] dp = new int [N+2] [N+2];
		for (int a = 1; a < N+1; a++) {
			for (int b = 1; b < N+1; b++) {
				dp[a][b] = dp[a][b-1] + dp[a-1][b] - dp[a-1][b-1] + arr[a][b];
			}
		}
		
		for (int i = 0; i < M; i++) {
			
			System.out.println("합을 구할 구간(x1, y1, x2, y2)");
			
			StringTokenizer to = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(to.nextToken());
			int y1 = Integer.parseInt(to.nextToken());
			int x2 = Integer.parseInt(to.nextToken());
			int y2 = Integer.parseInt(to.nextToken());
			
			//구간 합 배열로 질의에 답하기
			System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
			
		}

	}

}
