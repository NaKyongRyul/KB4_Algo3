package Day1.B10807_개수세기;

import java.io.IOException;
import java.util.Scanner;

public class B10807_개수세기_안도현 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];

		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		
        // v 찾아서 카운트 //
        int ans = 0;
		for(int i=0; i<N; i++) 
			if(arr[i] == v) ans++;
        System.out.println(ans);
	}
	
	
}
