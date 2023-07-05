package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_박찬욱 {
	
	static int N; // 사람의 수 (5 ≤ N ≤ 2000)
	static int M; // 친구 관계의 수 (1 ≤ M ≤ 2000)
	static ArrayList<Integer>[] redL; // 친구사이  (0 ≤ a, b ≤ N-1, a ≠ b)
	static boolean [] isVisited; // 선택 여부 확인
	static int ans; //친구관계에서 A - B - C - D - E가 있는지에 대한 여부, 있으면 1, 없으면 0
	/*
	 * 이 문제의 핵심은 전체 친구관계에서 A - B - C - D - E가 있는지에 대한 여부이다.
	 * = 경로 탐색에서 line이 4개 이상으로 5번 연속으로 이어져 있는 경우가 있어야 1을 받는다.
	 */
	public static void DFS(int start, int r) { // 순번을 이어가기위한 정점 start, 5번 반복을 확인하기위한 r
		if(r == 5) { // 5번 연속으로 이어져 있으면, 
			ans = 1;
			return;
		}
		
		isVisited[start] = true; // 배열 마킹 작업
		for(int i : redL[start]) { // ArrayList[start] 배열의 처음부터 반복
			int next = i; // 다음 번호로 선정하여 넘어가기위해 변수 선언
			if(!isVisited[next]) DFS(next, r+1); // 정점 next번은 선택하지 않았다면, DFS로 재귀
		}
		isVisited[start] = false; // 배열 마킹 해체 작업
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token  = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		redL = new ArrayList [N];
		for(int i = 0; i < N; i++) redL[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			token  = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(token.nextToken());
			int n2 = Integer.parseInt(token.nextToken());
			redL[n1].add(n2);
			redL[n2].add(n1);
		}
		
		isVisited = new boolean [N + 1];
		for(int i = 0; i < N; i++) {
			if(ans == 0) DFS(i, 1); // 답이 안나왓다면, DFS 진행 
		}
		
		System.out.println(ans);
	}
}