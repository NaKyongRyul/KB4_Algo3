package Day1.B10807_개수세기;

import java.util.Scanner;

public class B10807_개수세기_나영현 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int [] arr = new int [N];

		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		int v = sc.nextInt();

		int answer = 0;
		for (int num: arr){
			if (num == v) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}
