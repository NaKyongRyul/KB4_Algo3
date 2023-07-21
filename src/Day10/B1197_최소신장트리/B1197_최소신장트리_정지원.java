package Day10.B1197_최소신장트리;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1197_최소신장트리_정지원 {
static int[] parent;
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);
		}
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
			if(x<y) {
				parent[y] = x;
				
			}
			else {
				parent[x] = y;
			}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int answer = 0;
		ArrayList<Edge> edges = new ArrayList<>();
		parent = new int[V];
		
		for(int i=0;i<V;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<E;i++) {
			edges.add(new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
		}
		
		Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);
		
		
		for(int i=0;i<edges.size();i++) {
			if(find(edges.get(i).from) ==find(edges.get(i).to)) {//이미 같음	
			}
			else {
				union(edges.get(i).from,edges.get(i).to);
				answer+=edges.get(i).weight;
			}
		}
		
		System.out.println(answer);
		
	}
}

class Edge{
	
	Edge(int f, int t, int w){
		from = f;
		to = t;
		weight =w;
	}
	int from;
	int to;
	int weight;
	

}
