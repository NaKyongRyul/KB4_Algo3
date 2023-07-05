package Day6.B2839_설탕배달;

import java.util.Scanner;

public class B2839_설탕배달_이채림 {
	static int N;
	static int cnt;
	static int remain;
	// 3 or 5

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();// N킬로그램 배달
		
		int i = 0, min = 5000;
		remain = N;
		while(i <= remain/5) {//18 3
			//0
			for(int j = 0; j < i; j++) {
				remain -= 5;
				cnt++;
			}
			while(remain >= 3) {
				remain -= 3;
				cnt++;
			}
			if(remain == 0 && cnt < min) 
				min = cnt;
			i++;
			cnt = 0;
			remain = N;
		}
		if(min == 5000) min = -1;
		System.out.println(min);
		

	}

}
