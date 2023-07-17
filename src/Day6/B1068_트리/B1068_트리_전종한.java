package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1068_트리_전종한 {
	static int N;
	static ArrayList <Integer> [] arrList;
	static int [] parent ;
	static int delNode;
	static boolean [] visited;
	static int cnt;
	static int rootNode;

	public static void removeNode(int nowNode) {   // now : 부모  ->  next : 자식
		// 현재 노드를 방문한 것으로 표시
		visited[nowNode] = true;

		// 방문한 노드와 인접한 모든 노드 가져옴
		for(int nextNode : arrList[nowNode]) {
			if(delNode == nextNode) {
				arrList[nowNode].remove(Integer.valueOf(delNode));
				return;
			}
			// 방문하지 않은 노드면
			if(!visited[nextNode]) {
				// 순환호출
				removeNode(nextNode);
			}
		}
	}

	public static void countLeaf(int nowNode) {
		// 현재 노드를 방문한 것으로 표시
		visited[nowNode] = true;

		if(arrList[nowNode].size() == 0) {
			cnt ++;
		}
		// 방문한 노드와 인접한 모든 노드 가져옴
		for(int nextNode : arrList[nowNode]) {
			// 방문하지 않은 노드면
			if(!visited[nextNode]) {
				countLeaf(nextNode);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arrList = new ArrayList[N];
		visited = new boolean[N];
		parent = new int [N];
		for(int i=0; i<N; i++) {
			arrList[i] = new ArrayList <>();
		}
		String [] strs = bf.readLine().split(" ");
		for(int i=0; i<N; i++) parent[i] = Integer.parseInt(strs[i]);
		for(int i=0; i<N; i++) {
			if(parent[i] == -1) {
				rootNode = i;
				continue;
			}
			arrList[parent[i]].add(i);
		}

		// list.remove(Integer.valueOf(값));

		delNode = Integer.parseInt(bf.readLine());

		if(delNode == rootNode) System.out.println(0);
		else {
			removeNode(rootNode);

			visited = new boolean[N];
			cnt = 0;

			countLeaf(rootNode);

			System.out.println(cnt);			
		}
	}
}
