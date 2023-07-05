package Day6.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_윤소민 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int m = N/5;   
		int rnd = N%5; 
		int cnt=0;
		
		if(N%5==0) 
			cnt = N/5;
		else {
			for(int i=0;i<m;i++) {
				if((rnd+5*i)%3==0) {
					cnt+= (rnd+5*i)/3;
					cnt+=( N-(rnd+5*i))/5;
					break;
				}
			}
		}
		
		if(cnt==0) {
			if(N%3==0) {
				cnt = N/3;
				System.out.println(cnt);
			}
			else {
				System.out.println(-1);
			}
			
		}
		else {
			System.out.println(cnt);
		}
			
	}

}