package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1197_최소신장트리_전종한 {
	static int V, E; // V; 정점의 개수, E; 간선의 개수
	static ArrayList<Line> list;
	static int[] rootInfo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		rootInfo = new int[V+1];
		Arrays.setAll(rootInfo, (i) -> i);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Line(n1, n2, weight));
		}
		Collections.sort(list, (line1, line2) ->{
			return line1.weight - line2.weight;
		});

		int weightSum = 0;
		for(int i=0; i<list.size(); i++) {
			int node1 = list.get(i).n1;
			int node2 = list.get(i).n2;
			if(find(node1) == find(node2)) continue;
			union(node1, node2);
			weightSum += list.get(i).weight;
		}
		System.out.println(weightSum);
	}

	public static int find(int x) {
		if (x == rootInfo[x]) {
			return x;
		}
		return rootInfo[x] = find(rootInfo[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) rootInfo[y] = x;
			else rootInfo[x] = y;
		}
	}
}
class Line{
	public int n1;
	public int n2;
	public int weight;
	public Line(int n1, int n2, int weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}
}