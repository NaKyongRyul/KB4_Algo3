package Day1.B2018_수들의합;

import java.util.Arrays;
import java.util.Scanner;

public class pre_B2018_수들의합5_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int left = 1;
		int right = 1;
		int cnt = 0;

		while (left <= right) {
			int sum = right*(right+1)/2 - left*(left-1)/2;
			if (sum > N) {
				left += 1;

			} else if (sum < N) {
				right += 1;
				if (right > N) {
					break;
				}
			} else {
				left += 1;
				cnt += 1;
			}
		}
		System.out.println(cnt);

	} 

}
