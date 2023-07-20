package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_전종한 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(n > 0) {
			if(n%5 != 0) {
				n -= 3;
				cnt ++;
			}else {
				cnt += (n/5);
				System.out.println(cnt);
				System.exit(0);				
			}
		}
		if(n == 0) System.out.println(cnt);
		else if(n < 0) System.out.println(-1);
	}
}
