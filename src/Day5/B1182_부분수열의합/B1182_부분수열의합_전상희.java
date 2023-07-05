package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합 {
	static int S; // 합이 S가 되는 부분수열을 찾는 문제 
	static int N; // 정수의 개수
	static int[] arr; // 입력받을 배열
	static boolean[] isSelected;
	static int ans = 0;
	
	static void subset(int now) {
		if(now == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sum+= arr[i];
				}
			}
			if(sum==S) {
				ans++;
			}
			return;
		}		

		isSelected[now] = true;
		subset(now+1);
		
		isSelected[now] = false;
		subset(now+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		arr = new int[N];
		isSelected = new boolean[N];
		
		token = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		subset(0);
		
		if(S==0) ans-=1;
		System.out.println(ans);
		
	}
}
