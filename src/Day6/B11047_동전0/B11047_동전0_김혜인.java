package Day6.B11047_동전0;

import java.util.Scanner;

public class B11047_동전0_김혜인 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//인수받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  //동전개수
		int m = sc.nextInt();  //금액
		int [] A = new int[n];
		for(int i=0; i<n; i++) {
			A[i] = sc.nextInt();
		}
		
		
		//가격이 큰 동전부터 받기
		int count = 0; 
		for(int i=n-1; i>=0; i--) {
			if(A[i]<=m) {
				count += (m/A[i]); // (목표금액/동전금액)
				m = m%A[i]; //나머지 금액으로 반환
			}
		
		}
		System.out.println(count);
	}

}
