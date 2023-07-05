package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_길민지 {
	static int N, M;
	static int[] A;
	
	static int search(int num) {
		int high = N-1;
		int low = 0;
		while (low<=high) {
			int mid = (high+low) / 2;
			
			if (A[mid]==num) return 1; // 찾음
			else if (A[mid]>num) high = mid - 1; // 중앙값이 찾을 숫자보다 큰 경우
			else if (A[mid]<num) low =mid + 1; // 중앙값이 찾을 숫자보다 작은 경우
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for (int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); // 찾을 숫자 입력
			System.out.println(search(num)); // 수 찾고 출력
		}
	}
}
