package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_윤소민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			
		}
		int v = sc.nextInt();
		int cnt = 0;
		for (int i:arr) {
			if(i == v) cnt+=1;
		}
		System.out.println(cnt);

	}

}
