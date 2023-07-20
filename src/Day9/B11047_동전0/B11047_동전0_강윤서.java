package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_강윤서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 합
		
		// 동전 종류
		int[] coins = new int[n];
		for (int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 합을 만들기 위한 동전 개수 계산
		int count=0;
		for (int i=n-1; i>=0; i--) {
			if (k<coins[i]) continue; // 동전 값이 더 큰 경우 확인 필요 없음
			count+=k/coins[i]; // 몫 값
			k %= coins[i]; // 합의 나머지 값
			if (k==0) break;
		}
		System.out.println(count);
	}
}
