package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_곽승규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] ary = new int[N+1][N+1]; // 패딩 넣음
		
		// 배열에 값 넣기	
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//System.out.println(Arrays.deepToString(ary)); // 확인
		
		int [][] DP = new int[N+1][N+1]; // D[x][y] = (0,0)부터 (x,y)까지의 더한 합
		
		// 이차원 구간합 배열 만들기 
		for(int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + ary[i][j];
			}
		}
		//System.out.println(Arrays.deepToString(DP)); // 확인
		
		
		// 질의에 답하기
		for (int i = 0; i < M; i++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			result = DP[x2][y2] - DP[x2][y1-1] - DP[x1-1][y2] + DP[x1-1][y1-1];
			System.out.println(result);
		}
	}

}
