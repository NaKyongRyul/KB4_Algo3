package Day9.B11047_동전0;

import java.util.Scanner;

public class B11047_동전0_정지원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long k = sc.nextInt();
		int[] coins = new int[n];
		
		for(int i=n-1;i>=0;i--) {
			coins[i] = sc.nextInt();
		}
		
		int num=0;
		
		for(int i=0;i<n;i++) {
			num+= k/coins[i];
			k = k%coins[i];
		}
		
		System.out.println(num);
	}
}
