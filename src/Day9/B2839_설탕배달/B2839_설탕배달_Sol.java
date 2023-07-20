package Day9.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_Sol {


	// 첫번쨰 방법 = 나머지 이용
	public static void main2(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		
		if(N == 4 || N == 7) {
			System.out.println(-1);
		}

		else if(N % 5 == 0) {
			System.out.println(N / 5);
		}

		else if(N % 5 == 1 || N % 5 == 3) {
			System.out.println(N / 5 + 1);
		}

		else if(N % 5 == 2 || N % 5 == 4) {
			System.out.println(N / 5 + 2);
		}

	}
	

	// 두번째 방법 = while 문 이용 
	public static void main1(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt_3 = -1;
		int cnt_5;

		cnt_5 = N/5;

		while(cnt_5 >= 0) {
			// 나누어 떨어지는 경우
			if( (N - 5*cnt_5)%3  == 0 ) {
				cnt_3 = (N - 5*cnt_5)/3;
				break;
			}
			else {
				cnt_5--;
			}
		}

		if(cnt_3 == -1) System.out.println(-1);
		else System.out.println(cnt_5 + cnt_3);

	}
}

