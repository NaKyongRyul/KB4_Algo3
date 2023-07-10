package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_나웅기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = 1;
		for (int i = 1; i<N; i++) {
			int sum = i;
			for (int j = i+1; j<N; j++) {
				sum += j;
				if (sum == N) {
					result += 1;
					break;
				} else if (sum > N) {
					break;	
				}
			}
		}
		System.out.println(result);
	}
}
