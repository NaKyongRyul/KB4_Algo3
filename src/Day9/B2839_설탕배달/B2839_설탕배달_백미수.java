package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_백미수 {

	static int N;
	static int ans = 0;
	
	//아이디어
	public static void Count(int sum) {
		
		if(sum!=0 && sum!=3 &&sum<5) {
			System.out.println("-1");
			return;
		}
		
		if(sum==0) {
			System.out.println(ans);
			return;
		}
		
		//5로 나눴을때 나머지 3의 배수면 나눠도 됨
		if(sum/5!=0) {
			if(sum%5 == 3 ||sum%5 == 0) {
				ans = ans + 1;
				sum = sum - 1*5;
				Count(sum);
			}else{//5로 나눠져도 3의 배수로 나눠 안 떨어질 수 있음
				ans = ans + 1;
				sum = sum - 1*3;
				Count(sum);
			}
		}else{//5로 안 나눠져도 3으로 나눠질 수 있음
			ans = ans + 1;
			sum = sum - 1*3;
			Count(sum);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		Count(N);
	}
}
