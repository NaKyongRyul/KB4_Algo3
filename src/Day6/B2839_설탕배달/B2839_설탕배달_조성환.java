package Day6.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int min = -1;
		for(int i = 0 ; i <= N ; i++) {
			int rem = N - (5*i);
			if(rem % 3 == 0 && rem >= 0) {
				min = i + (rem /3);
			}
		}
		System.out.println(min);
	}
}