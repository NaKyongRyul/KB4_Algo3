package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0; //int cnt5; int cnt3;
		int cnt = 0;
		
		while(sum != N) {
			// 최대한 5를 많이 쓰다가
			if (sum < N) {
				sum += 5;
				cnt++;
//				System.out.println("sum에서 5더해줌, sum: " + sum + "cnt: "+ cnt);
			// 합이 넘어가면 5 빼주면서 빼준 값이 3으로 나뉘는지 확인
			} else {
				sum -= 5;
				cnt--;
//				System.out.println("sum에서 5더해줌, sum: " + sum + "cnt: "+ cnt);
				while (true) {
//					System.out.println("sum에서 5더해줌, sum: " + sum + "cnt: "+ cnt);
					if (sum == N) {
						break;
					}
					if (sum < 0) {
						System.out.println(-1);
						return;
					}
					if ((N - sum) % 3 == 0) {
						sum += 3;
						cnt++;
					} else {
						sum -= 5;
						cnt--;
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
