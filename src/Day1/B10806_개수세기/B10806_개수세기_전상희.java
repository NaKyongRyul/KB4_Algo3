package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_전상희 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int v;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		v = sc.nextInt();
		int count = 0;
		for(int a : arr) {
			if(a == v) {
				count++;
			}
		}
		System.out.println(count);
	}
}
