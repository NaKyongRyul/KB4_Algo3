package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B2018_수들의합_윤소민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int start =1, end = 1;
		int cnt =0, sum =1;
		
		while(end<N) {
			if(sum<N) {
				end++;
				sum +=end;
			}
			else if(sum > N) {
				sum -= start;
				start++;
				
			}else {
				end++;
				sum += end;
				cnt++;
			}
		}
		System.out.println(cnt+1);
	}

}

