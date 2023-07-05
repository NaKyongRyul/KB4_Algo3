// 배열 사용
package Day5.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1068_트리_길민지 {
	static int N, delN; // 노드 개수, 지울 노드
	static int rootN; // 루트노드
	static int parent[]; // 부모 배열
	static boolean isVisited[]; // 방문 여부
	static int cnt; // 리프노드 개수
	
	static void findLeaf(int node) {
		isVisited[node] = true; // 방문 체크
		
		boolean isLeaf = true;
		for (int i=0; i<N; i++) {
			if (isVisited[i] == false && parent[i] == node) { // 자식 노드가 있다면
				isLeaf = false; // 리프 노드 X
				findLeaf(i); // 자식 노드 방문
			}
		}
		if (isLeaf == true) { // 리프노드라면
			cnt++; 
			return; // 재귀 종료
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 첫번째줄 입력
		N = Integer.parseInt(st.nextToken());
		
		// 초기화
		parent = new int[N];
		isVisited = new boolean[N];
		rootN = -1;
		
		// 두번째줄 입력
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if (parent[i]==-1) rootN = i;
		}
		
		// 세번째줄 입력
		st = new StringTokenizer(bf.readLine());
		delN = Integer.parseInt(st.nextToken());
		isVisited[delN] = true; // 지운 노드는 방문처리해서 그 아래로 탐색하지 않게 함
		
		if (delN!=rootN) findLeaf(rootN); // 지운 노드가 루트 노드라면 cnt = 0
		System.out.println(cnt);
	}

}

// ArrayList 사용
/*
package Day5.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068_트리_길민지2 {
	static int N, delN;
	static int rootN;
	static int parent[];
	static ArrayList<Integer> tree[];
	static int cnt;
	
	static void findLeaf(int node) {
		boolean isLeaf = true;
		for (int child : tree[node]) { // 자식 노드 탐색
			if (child!=delN) {  // 지울 노드가 아니라면
				isLeaf = false; // 리프 노드 X
				findLeaf(child); // 자식 노드 방문
			}
		}
		if (isLeaf == true) { // 리프노드라면
			cnt++; 
			return; // 재귀 종료
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 첫번째줄 입력
		N = Integer.parseInt(st.nextToken());
		
		// 초기화
		parent = new int[N];
		rootN = -1;
		tree = new ArrayList[N];
		for(int i=0; i<N; i++) tree[i] = new ArrayList<>();
		
		// 두번째줄 입력
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent==-1) rootN = i; // 루트노드 저장
			else tree[parent].add(i); // 리스트에 자식 노드 저장 
		}
		
		// 세번째줄 입력
		st = new StringTokenizer(bf.readLine());
		delN = Integer.parseInt(st.nextToken()); // 지울 노드
		
		if (delN!=rootN) findLeaf(rootN); // 지운 노드가 루트 노드라면 cnt = 0
		System.out.println(cnt);
	}

}
*/
