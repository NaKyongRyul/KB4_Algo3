package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_길민지 {

	public static void main(String[] args) {
		// Scanner 이용
		
		Scanner sc = new Scanner(System.in);
				
		int N = sc.nextInt();
		int arr [] = new int [N];
				
		for (int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
				
		int findNum = sc.nextInt();
		int result = 0;
				
		for(int i : arr) {
			if (findNum==i) result++;
		}
		
		System.out.println(result);
		sc.close();

	}

}
