package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합5_전종한 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 0; int end = 0;
		int sum = 0; int cnt = 0;
		while(start <= N) {
			if(sum < N) {
				end++;
				sum += end;
			}else if(sum > N) {
				start ++;
				sum -= start;
			}else if(sum == N) {
				cnt ++;
				start++;
				sum -= start;
			}
		}
		System.out.println(cnt);

	}
}
