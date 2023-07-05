package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_서은효 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int[1];
		int answer = 0;
		
		for(int i = 1;i<=N;i++) {
			int sum =0;
			for(int j = i; j<=N;j++) {
				sum = sum + j;
				if(sum > N) break;
				else if(sum == N ) {
					
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
		
	}

}
