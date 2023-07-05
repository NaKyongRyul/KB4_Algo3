package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_전상희 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " "); // 구분자 지정(default : 공백)

		int N = Integer.parseInt(token.nextToken());		
		int M = Integer.parseInt(token.nextToken());
				
		token = new StringTokenizer(bf.readLine(), " ");
		int[] sum = new int[N+1];		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
			sum[i+1] = sum[i] + arr[i];
		}
		
		int m, n;
		int[] ans = new int[M];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			m = Integer.parseInt(token.nextToken());
			n = Integer.parseInt(token.nextToken());
			if(m==n) ans[i] = arr[m-1];
			else ans[i] = sum[n]-sum[m-1];
		}
		
		for(int a : ans) System.out.println(a);
	}
}
