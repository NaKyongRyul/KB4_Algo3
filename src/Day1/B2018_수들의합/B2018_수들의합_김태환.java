package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_김태환 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int answer=0;
		for(int i=1;i<N;i++) {
			int sum=0;
			for(int j=i;j<=N/2+1;j++) {
				sum+=j;
				if (sum==N) {
					answer+=1;
				break;}
				else if(sum>N) {
					break;}
//				System.out.println(sum);
				
		}

	}
		System.out.println(answer+1);
}
}
