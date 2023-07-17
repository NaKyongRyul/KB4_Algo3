package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_강윤서 {
	static ArrayList<Integer>[] tree;
	static boolean[] isVisited; // 방문 여부 저장
	static int[] whoParents; // 부모 정보 저장
	
	public static void dfs(int index) { // 깊이 우선 탐색-재귀
		isVisited[index] = true;
		
		for (int i : tree[index]) { // 자식 확인
			if (!isVisited[i]) { // 아직 확인하지 않은 자식
				whoParents[i]=index; // 부모 설정
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		isVisited = new boolean[n+1];
		whoParents = new int[n+1];
		
		// 트리 구조
		tree = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 트리 그래프 구조
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			tree[one].add(two);
			tree[two].add(one);
		}
	
		dfs(1);
		
		// 결과 출력
		for (int i=2; i<whoParents.length; i++) {
			System.out.println(whoParents[i]);
		}
	}
}
