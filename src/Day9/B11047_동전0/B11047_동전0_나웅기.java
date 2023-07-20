package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_나웅기 {
	static int n;
	static int k;
	static int [] money;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		money = new int [n];
		for (int i = 0; i<n; i++) {
			money[i] = Integer.parseInt(reader.readLine());
		}
		
		for (int i = n-1; i>=0; i--) {
			if (k == 0) break;
			if (k/money[i]>0) {
				result += k/money[i];
				k = k%money[i];
			}
		}
		
		System.out.println(result);
	}
}
