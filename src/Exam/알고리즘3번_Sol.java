package Exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고리즘3번_Sol {
	
	static int N, M, ans;
	static int[] arr;
	
	// 백트래킹 => DFS 구현
	public static void dfs(int n, int m, int sum) {
		
		// 재귀 종료 = 배열이 끝에 닿은 경우 (n>N) or 시간제한 (m == M+1)
		if (n>N || m==M+1) {
			return;
		}
		
		// 종료가 아니라면 최댓값 갱신
		ans = Math.max(ans, sum);
		
		// 굴리는 경우
		if (n<=N-1) {
			dfs(n+1, m+1, sum+arr[n+1]);	
		}
		
		// 던지는 경우
		if (n<=N-2) {
			dfs(n+2, m+1, sum/2+arr[n+2]);	
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		ans = 0;
		dfs(0, 0, 1);
		System.out.println(ans);
		
	}


}