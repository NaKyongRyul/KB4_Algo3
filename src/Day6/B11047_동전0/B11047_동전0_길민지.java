package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_길민지 {
	static int N, K;
	static int A[];
	static int cnt;
	
	static void findMin() {
		for (int i=N-1; i>=0; i--) { // 가치가 큰 동전부터 탐색
			if (K>=A[i]) {
				int n = K/A[i];
				K = K - A[i]*n;
				cnt+=n;
			}
			if (K==0) break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int [N];
		for (int i=0; i<N; i++) A[i] = Integer.parseInt(bf.readLine());
		
		// 최솟값 찾기
		findMin();
		
		// 출력
		System.out.println(cnt);
	}
}
