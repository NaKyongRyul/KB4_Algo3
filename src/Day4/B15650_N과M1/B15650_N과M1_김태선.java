package Day4.B15650_N과M1;

import java.util.Scanner;

public class B15650_N과M1_김태선 {

	
	static int [] arr;
	static int N, M;   				
	

	static void combination(int idx , int n) {

		if(idx == M) {
			for(int s : arr) {
				System.out.print(s + " ");	
			}
			System.out.println();
			
		} else {
			for(int i = n + 1; i <= N; i++) {
				arr[idx] = i;
				combination(idx + 1, i);
			}
		}

	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int [M];
		
		combination(0, 0);

	}
}
