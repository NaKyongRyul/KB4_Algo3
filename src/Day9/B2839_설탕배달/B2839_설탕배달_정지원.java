package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_정지원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int answer = 0;
		int num5;
		
		num5 = n/5;
		n %=5;
		
		answer += n/3;
		
		if(n%3==1) {
			if(num5 >=1) {
				answer++;
				answer+=num5;
			}
			else {
				answer = -1;
			}
		}
		else if(n%3==2) {
			if(num5>=2) {
				answer+=2;
				answer+=num5;
			}
			else {
				answer = -1;
			}
			
		}
		else {answer += num5;}
		
		System.out.println(answer);
	}
}
