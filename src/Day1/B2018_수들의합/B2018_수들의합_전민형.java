package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_전민형 {

	public static void main(String[] args) {

		int start,end,sum,cnt,N;
		start=1;
		end=1;
		sum=1;
		cnt=0;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		while(end<=N) {
			if(sum<N) sum += ++end;
			else if(sum>N) sum-= start++;
			else {
				cnt++;
				sum += ++end;
			}
		}
		
		System.out.println(cnt);

	}
	
	

}
