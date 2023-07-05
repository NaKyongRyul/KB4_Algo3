package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합5_박상희 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(bf.readLine());
		int answer = 0;
		
		int start = 1;
		while (start <= N) {
			int sum = 0;
			
			for (int i = start; i <= N; i++) {
				sum += i;
				
				if (sum == N) {
					answer++;
					break;
				}
				else if (sum > N) {
					break;
				}
			}
			
			start++;
		}
		
		System.out.println(answer);
	}
}
