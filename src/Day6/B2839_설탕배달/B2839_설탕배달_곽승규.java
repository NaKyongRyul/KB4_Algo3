package Day6.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_곽승규 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		//처음에 5kg 봉지로 몇개 담을 수 있는지 체크
		count = N / 5;
		N = N % 5;
		
		
		while(true) {
			if (count < 0) {
				break;
			}
			if (N % 3 == 0) { // 나머지가 3으로 나눠 떨어지면 그거만큼 카운트하고 break 
				count += N / 3;
				break;
			}
			else { //3으로 나눠떨어지지 않으면 count 내리고 다시 5 더함
				count -= 1;
				N = N + 5;
			}
		}
		System.out.println(count);

	}

}
