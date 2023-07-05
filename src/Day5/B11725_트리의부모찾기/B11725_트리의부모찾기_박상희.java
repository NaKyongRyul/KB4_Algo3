package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_박상희 {
	static int N;
	static ArrayList<Integer> tree [];
	static boolean [] isVisited;
	static int [] parent; // 부모를 저장할 배열
	
	static void Search(int root) {
		for (int nextNode: tree[root]) {
			if (!isVisited[nextNode]) { // 아직 방문하지 않은 노드라면
				isVisited[nextNode] = true;
				Search(nextNode);
				parent[nextNode] = root;
			}
			else {
				continue;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		tree = new ArrayList[N + 1];
		isVisited = new boolean [N + 1];
		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int n = 0; n < N - 1; n++) {
			StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			
			tree[u].add(v);
			tree[v].add(u);
		}
		parent = new int [N + 1];
		
		isVisited[1] = true;
		Search(1);
		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}
	}
}
