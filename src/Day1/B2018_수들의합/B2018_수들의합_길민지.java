package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_길민지 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int result = 1; // 자기 자신
		for (int i=1; i<N; i++) {
			int sum = i;
			for(int j=i+1; j<=N; j++) {
				if (sum == N ) {
					result++;
					System.out.println(i+ " "+j);
					break;
				}
				if (sum>N) break;
				sum+=j;
			}
		}
		System.out.println(result);
	}
}
