package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기4_장재은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int preSum [] = new int[n+1];
		
		String [] strs = reader.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			preSum[i+1] = preSum[i] + Integer.parseInt(strs[i]);
		}
		
		for(int j=0; j<m; j++) {
			StringTokenizer st2 = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			int sum = preSum[b] - preSum[a - 1];
			System.out.println(sum);
		}
	}
}
