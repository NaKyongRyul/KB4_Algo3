package day06;

import java.util.Scanner;

public class B2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 N킬로그램
		
		int max = N / 3;
		int min = 9999;
		
		for(int i=0; i<=max; i++) {
			for(int j=0; j<=max; j++) {
				if((3*i + 5*j == N) && (i+j < min)) {
					min = i+j;
				}
			}
		}
		
		if(min==9999) min = -1;
		
		
		System.out.println(min);	
	}
}
