package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_김진형 {
	private static int N; // 도시의 수
	private static int M; // 예행계획 도시 수

	private static int[][] adMatrix;
	private static int[] rootInfo;

	private static int[] tripSeq;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				adMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tripSeq = new int[M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			tripSeq[i] = Integer.parseInt(st.nextToken());
		}

		// 모든 여행경로에 속하는 노드가 동일한 루트를 가지고 있어야함
		// 그럼, 노드에 대한 루트 노드 정보가 필요

		rootInfo = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			rootInfo[i] = i;
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (adMatrix[i][j] == 1) {
					union(i, j);
				}
			}
		}

		int root = rootInfo[tripSeq[0]];
		for (int i = 0; i < M; ++i) {
			if (root != rootInfo[tripSeq[i]]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int node1, int node2) {
		int node1_root = find(node1);
		int node2_root = find(node2);

		if (node1_root != node2_root) {
			if (node1_root < node2_root) {
				rootInfo[node2_root] = node1_root;
			} else {
				rootInfo[node1_root] = node2_root;
			}
		}
	}

	private static int find(int node) {
		if (rootInfo[node] == node) {
			return node;
		} else {
			return rootInfo[node] = find(rootInfo[node]);
		}
	}
}
