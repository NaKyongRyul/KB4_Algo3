package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_길민지 {
	static ArrayList <Integer> [] arr;
	static int N, M;
	static boolean flag;
	static boolean isSelected [];
	
	static void findFriends(int start, int r) {
		if (r == 4 || flag == true) { // 연속된 다섯 친구를 구했거나, 이미 구한 경우 종료
			flag = true;
			return;
		}
		
		for (int i : arr[start]) { // 방문하지 않은 인접 노드 탐색
			if (isSelected[i]) continue;
			isSelected[i] = true; // 방문 노드 저장
			findFriends(i, r+1);
			isSelected[i] = false; // 되돌아온 노드 삭제
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 입력 및 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		for (int i=0; i<N; i++) arr[i] = new ArrayList<Integer>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for (int i=0; i<N; i++) { // 모든 점을 시작점으로 돌며 함수 실행
			isSelected = new boolean[N];
			isSelected[i] = true;
			findFriends(i, 0);
		}
		
		if (flag == true) System.out.println(1); // 찾음
		else System.out.println(0); // 못 찾음
	}
}
