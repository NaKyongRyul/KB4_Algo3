package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_김태선 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader (System. in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int[] dp = new int [N+1];
		
		//dp는 idx 1부터 시작한다.
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			//현재 = 이전값 + 현재넣을값
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			//구간합
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[B] - dp[A - 1]);
		}
		
		
		
	}

}
