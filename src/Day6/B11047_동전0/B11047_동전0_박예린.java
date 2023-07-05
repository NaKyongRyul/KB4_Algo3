package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_박예린 {
	static void findMin(int[] arr, int N, int K) {
		int res = 0;
		int num = 0;

		while (K > 0) {
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > K)
					continue;
				else {
					num = K / arr[i];
					res += num;
					K = K - num * arr[i];
				}
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		findMin(arr, N, K);
	}
}