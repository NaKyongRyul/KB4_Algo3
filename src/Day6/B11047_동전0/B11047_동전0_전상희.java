package day06;

import java.util.Arrays;
import java.util.Scanner;

public class B11047_동전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 종류 수
		int K = sc.nextInt(); // 만들고자 하는 가치의 합
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int count = 0;
		int left = K;
		
		while(sum != K) {
			int max = 0;
			for(int a : arr) {
				if(a<=left && a>max) max = a;
			}
			
			if(sum + max <= K) {
				sum += max;
				left -= max;
				count++;
			}
		}
		
		System.out.println(count);		
	}
}
