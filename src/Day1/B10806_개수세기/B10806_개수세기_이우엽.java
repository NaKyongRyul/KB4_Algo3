package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_이우엽 {
	/**
	 * 백준10806 개수세기
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int find = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] == find) cnt++;
		}
		sc.close();
		System.out.println(cnt);

	}

}
