package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0 ; 
		
		int [] arr = new int [N];
		
		for (int i = 0, L = arr.length  ; i < L ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = N - 1 ; i >= 0 ; i--) {
			cnt += M / arr[i];
			M %= arr[i];
		}
		System.out.println(cnt);
	}
}
