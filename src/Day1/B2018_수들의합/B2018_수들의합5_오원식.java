package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합5_오원식 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int cnt = 0;
		int temp = 1;
		
		while (temp<n+1) {
			int sum = 0;
			for(int i = temp; i<n+1; i++) {
				sum += i;
				if(sum > n) break;
				if(sum == n) {
					cnt += 1;
					break;
				}
			}
			temp += 1;
		}
		System.out.println(cnt);	
	}
}
