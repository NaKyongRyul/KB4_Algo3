package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_황혜령 {

	static int[] sugar;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		sugar = new int[n + 1];
		
		System.out.println(howManySugarBag(n));
	}

	static int howManySugarBag(int n) {
		if(n == 3 || n == 5) 
			sugar[n] = 1;
		
		if(n == 4 || n == 7)
			sugar[n] = -1;
		
		else {
			if(n % 5 == 0)
				sugar[n] = (n / 5);

			else if(sugar[n - 3] != -1)
				sugar[n] = howManySugarBag(n - 3) + 1;
		}
		
		return sugar[n];
	}
}