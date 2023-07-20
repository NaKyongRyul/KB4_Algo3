package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_장재은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int [N][2];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());	
			
			arr[i][0] = a;
			arr[i][1] = b;
		}
		Arrays.sort(arr, (a,b) -> ((a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]) );
		
		int finish = 0;
		for(int i=0; i<N; i++) {
			if(arr[i][0] >= finish) {
				cnt++;
				finish = arr[i][1];
			}
		}
		System.out.println(cnt);
	}
}