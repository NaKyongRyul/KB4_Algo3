package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10807_개수세기_박상희 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		
		int count = 0;
		for (int j = 0; j < N; j++) {
			if (arr[j] == v) {
				count += 1;
			}
		}
		
		System.out.println(count);
	}
}
