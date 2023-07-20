package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_장재은 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = -1;
		
		for(int i=N/5; i>=0; i--) {
			if((N - 5 * i) % 3 == 0) {
				cnt = i + (N - 5 * i) / 3;
				break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}