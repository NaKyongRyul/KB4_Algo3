package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11659_구간합구하기4_오원식 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		String [] arr = reader.readLine().split(" ");
		int [] arr2 = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		
		int [] dp = new int[n+1];
		
		for(int i = 1; i<arr2.length+1; i++) {
			dp[i] = dp[i-1] + arr2[i-1];
		}
		
		for(int i = 0; i<m; i++) {
			String [] input2 = reader.readLine().split(" ");
			int start = Integer.parseInt(input2[0]);
			int end = Integer.parseInt(input2[1]);
			System.out.println(dp[end]-dp[start-1]);
		}
		
		}
}


