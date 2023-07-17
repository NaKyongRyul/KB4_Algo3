package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068_트리_Sol {


/// 트리 구조 만들어서 탐색
// 1. 트리 연결 표현 인접 리스트 => 자식-부모 노드 연결 , u -> v 단방향 연결
// 2. 트리 연결 삭제 = 인접리스트에서 K 값 삭제 및 탐색시 노드가 K 인 경우 return 하도록
// 3. 말단 노드 확인? = tree[nowNode].size() == 0 인 경우

	static ArrayList <Integer> [] tree;
	static int N;
	static int K;
	static int root;
	static int cnt = 0;
	
	public static void DFS(int nowNode) {
		
		// 루트노드가 K인 경우
		if(nowNode == K) 
        	return; 
		
		// 말단노드인 경우 = 정답카운트+
		if(tree[nowNode].size() == 0) cnt++;
		
		// 다음 노드 탐색
		for(int nextNode : tree[nowNode]) 
			DFS(nextNode);
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(io.readLine());
		
		// 인접리스트 초기화
		tree = new ArrayList [N];
		for(int i=0; i<N; i++) tree[i] = new ArrayList<>();
		
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(token.nextToken());
			if(parent==-1)
                root = i; 
			else 
                tree[parent].add(i);
		}

		// 인접리스트에서 K 값들 전부 삭제 
		K = Integer.parseInt(io.readLine());
		for(int i=0; i<N; i++) {
			tree[i].remove(Integer.valueOf(K));
		}
	
		// 루트노드 탐색
		DFS(root);
		
		// 정답 출력
		System.out.println(cnt);
	}

}
