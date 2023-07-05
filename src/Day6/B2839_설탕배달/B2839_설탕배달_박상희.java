package Day6.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int first = N;
		int count = 0;

		while (N >= 5) {
			N -= 5;
			count++;
		}
		
		if (N % 3 != 0) {
			while (true) {
				N += 5;
				count--;
				
				if (N > first) {
					count = -1;
					break;
				}
				
				if (N % 3 == 0) {
					count = count + N / 3;
					N %= 3;
					break;
				}
			}
		}
		else {
			count = count + N / 3;
			N %= 3;
		}
		
		System.out.println(count);		
	}
}
