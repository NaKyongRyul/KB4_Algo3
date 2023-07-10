package Day1.B11659_구간합구하기4;

import java.util.Arrays;
import java.util.Scanner;

public class B11659_구간합구하기4_황혜령 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] sum = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
				
		for(int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println(sum[e] - sum[s - 1]);
		}
		
	}
}
