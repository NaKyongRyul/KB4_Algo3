package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기4_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		token = new StringTokenizer(bf.readLine());
		
		int nArr[] = new int[N];
		int sum[] = new int[N];
		for (int n = 0; n < N; n++) {
			nArr[n] = Integer.parseInt(token.nextToken());
			
			if (n == 0) {
				sum[0] = nArr[0];
			}
			if (n > 0) {
				sum[n] = sum[n - 1] + nArr[n];
			}
		}
		
		int result = 0;
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine());
			
			int i = Integer.parseInt(token.nextToken());
			int j = Integer.parseInt(token.nextToken());
			
			if (i == 1) {
				result = sum[j - 1];
			}
			else {
				result = sum[j - 1] - sum[i - 2];
			}
			
			System.out.println(result);
		}
	}
}
