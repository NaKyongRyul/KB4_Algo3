package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합5_나경률 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;		
		int start = 1;
		int end = 1;
		int sum = 1;
		
		while(end != N) {
			if(sum < N) {
				sum += ++end;
			} else if(sum > N) {
				sum -= start++;
			} else {
				count++;
				sum -= start++;
			}
		}
		System.out.println(count+1);
	}

}
