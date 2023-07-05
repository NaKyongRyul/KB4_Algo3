package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int ans = 0;
		
		// 2중 for문으로 해결
		
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = i; j <= N; j++) {
				sum += j;
				if(sum > N) break;
				else if(sum == N) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
