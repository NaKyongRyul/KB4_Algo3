package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_정지원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		int i=1;
		int j=1;
		
		while(j<=n) {
			if((i+j)*(j-i+1)/2==n){
				count++;
				j++;
				i++;
				
			}
			else if((i+j)*(j-i+1)/2>n) {
				i++;
			}
			else {
				j++;
			}
		}
		System.out.println(count);

	}
}
