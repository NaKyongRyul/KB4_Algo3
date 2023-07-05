package Day6.B11047_동전0;

import java.util.Scanner;

public class B11047_동전0_김태환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		int [] arr= new int [N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int dong=0;
		for(int j=N-1;j>=0;j--) {
			if (K%arr[j]<K) {
				dong+=K/arr[j];
				K=K%arr[j];
			}
		}
		System.out.println(dong);
	
	}

}
