package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// 입력 처리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(token.nextToken()); // 수의 개수
		int m = Integer.parseInt(token.nextToken()); // 합을 구해야하는 개수
		int [] arr = new int[n];
		int [] sum = new int[n+1]; 
		
		token = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		sum[1] = arr[0];
		for(int i = 2; i < n+1; i++) {
			sum[i] = sum[i-1] + arr[i-1];
		}
		
		for(int i = 0; i < m; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int start = Integer.parseInt(token.nextToken()); // 구간의 첫 부분
			int last = Integer.parseInt(token.nextToken()); // 구간의 마지막 부분
			System.out.println(sum[last] - sum[start-1]);
		}
	}
}
