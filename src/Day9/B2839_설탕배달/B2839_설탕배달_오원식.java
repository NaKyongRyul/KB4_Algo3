package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_오원식 {
	
	static int N;
	static int res;
	
	public static void count() {
		if(N%5 == 0) {
			res = N/5;
			return;
		}
		
		while(N > 0) {
			res += 1;
			N -= 3;
			
			if(N%5 == 0) {
				res += N/5;
				return;
			}
			
			else if(N == 1 || N == 2) {
				res = -1;
				return;
			}
			
			else if(N == 0) {
				return;
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		count();
		System.out.println(res);
		
	}

}
