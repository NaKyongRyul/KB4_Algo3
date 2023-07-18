package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068_트리_김현지 {
	static int N;
	static int removeNode;
	static int rootNode;
	static ArrayList <Integer>[] tree;
	static boolean [] visited;
	static int [] parents;
	static int deletedLeafNum;
	static int leafNum;
	static int newLeafNum;
	static int ans;

	
	public static void removeLeaf(int nowNode) {
//		System.out.println("nowNode: " + nowNode);
		// 리프노드 혹은 루트노드일 경우
		if (tree[nowNode].size() == 0) {
			deletedLeafNum++;
			return;
		}
		
		// 확장
		for (int nextNode : tree[nowNode]) {
			// 중복 확인
			if (visited[nextNode]) continue;
			
			// 다음 재귀
			visited[nextNode] = true;
			removeLeaf(nextNode);
			visited[nextNode] = false;
		}
	}
	
	
	public static int countLeaf() {
		for(int i=0; i<N; i++) {
			if (tree[i].size() == 0) {
				leafNum++;
			}
		}
		return leafNum;
	}


	public static void main(String[] args) throws IOException {
		// 입력받는 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		
		// 배열 원소를 인스턴스로 지정, 초기화
		visited = new boolean [N];
		tree = new ArrayList [N];
		parents = new int [N];

		
		for (int i=0; i<N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		
		// 인접행렬 입력받기
		int parentNode;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i< N; i++) {
			parentNode = Integer.parseInt(st.nextToken());
			parents[i] = parentNode;
			// 루트노드일 때
			if (parentNode == -1) {
				rootNode = i;
			// 루트노드가 아닐 때
			} else {
				tree[parentNode].add(i);
			}
		}
		
//		// tree에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(tree[i]);
//		}
		
		removeNode = Integer.parseInt(br.readLine());


		// 루트노드를 삭제한다면 답은 0
		if (removeNode == rootNode) {
			ans = 0;
			System.out.println(ans);
			return;
		}
		
		// 삭제된 leaf 갯수 구하기
		removeLeaf(removeNode);
		
		
		// 새로 생성된 leaf 갯수 구하기
//		System.out.println("parents: " + Arrays.toString(parents));
//		System.out.println("removeNode: " + removeNode);
		if (tree[parents[removeNode]].size() == 1) {
			newLeafNum = 1;
		}

		
		
		// 리프노드의 갯수 구하기
		// 처음의 leaf 갯수 - 삭제된 leaf 갯수 + 새로 생성된 leaf 갯수
		int originalLeafNum = countLeaf();
//		System.out.println("originalLeafNum: " + originalLeafNum + ", deletedLeafNum: " + deletedLeafNum + ", newLeafNum: " + newLeafNum);

		ans = originalLeafNum - deletedLeafNum + newLeafNum;
		System.out.println(ans);

	}

}
