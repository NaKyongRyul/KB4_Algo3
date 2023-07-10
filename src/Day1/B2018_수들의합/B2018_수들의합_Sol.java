package Day1.B2018_수들의합;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_Sol {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int tot = 1;
		int count = 0;
		int start = 1;
		int end = 1;
		
		// end 가 n 에 도달할 때까지 반복
		while(end != n) {
			if(tot < n ) tot += ++end;
			else if(tot > n) tot -= start++;
			else {
				count++;
				tot -= start++;
			}
			
		}
		System.out.println(count + 1);
	}
	}
