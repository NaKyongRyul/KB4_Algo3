package Day8.J1828_냉장고;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J1828_냉장고_Sol {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] fridge = new int[N][2];
		for (int i = 0; i < N; i++) {
			fridge[i][0] = sc.nextInt();
			fridge[i][1] = sc.nextInt();
		}
		
		// 최고온도 기준으로 정렬
		Arrays.sort(fridge, (a,b) -> a[1] - b[1]);	
		
		int cnt = 1;				// 냉장고 cnt
		int temp = fridge[0][1];  	// 최고온도 기준으로 냉장고 온도 설정
		for (int i = 1; i < N; i++) {
			// 현재 냉장고 온도 < 화학물질 최저온도 or 현재 냉장고 온도 > 화학물질 최고온도 => 새로운 냉장고 필요
			if (fridge[i][0] > temp || fridge[i][1]<temp) {
				temp = fridge[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

