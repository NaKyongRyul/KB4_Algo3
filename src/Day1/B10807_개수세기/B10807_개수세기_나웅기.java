package Day1.B10807_개수세기;

import java.util.Scanner;

public class B10807_개수세기_나웅기 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int [] arr = new int [N];
	for (int i = 0; i < N; i++) {
		arr[i] = sc.nextInt();
	}
	int cnt = 0;
	int v = sc.nextInt();
	for (int i : arr) {
		if (v == i) {
			cnt++;
		}
	}
	System.out.println(cnt);
	
	}
}
