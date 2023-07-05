package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_곽승규 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0; 
		
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		
		while (end_idx != N) { 
			if (sum == N) {
				count += 1;
				end_idx += 1;
				sum += end_idx;
			}
			else if (sum > N) {
				sum -= start_idx;
				start_idx += 1;
			}else {
				end_idx += 1;
				sum += end_idx;
			}
		}
		

		
		System.out.println(count + 1); // 자기 자신도 포함해서 +1	
	}

}
