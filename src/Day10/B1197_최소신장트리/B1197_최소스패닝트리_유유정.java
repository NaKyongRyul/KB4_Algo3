package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1197_최소스패닝트리_유유정 {
	static int V;
	static int E;
	static int [] parent;
	static int answer;
	static class Node{
		Node(int u, int v, int weight){
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		int u, v ,weight;
	}
	static Node [] edge;
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(a < b) parent[b]=a;
			else parent[a] =b;
		}
			
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String []strs = s.split(" ");
		V = Integer.parseInt(strs[0]);
		E = Integer.parseInt(strs[1]);
		edge = new Node [E];
		parent = new int [V+1];
		for(int i=0;i<V+1;i++)
			parent[i] = i;
		int A,B,C;
		
		for(int i=0;i<E;i++) {
			s = bf.readLine();
			strs = s.split(" ");
			
			A = Integer.parseInt(strs[0]);
			B = Integer.parseInt(strs[1]);
			C = Integer.parseInt(strs[2]);
			edge[i] = new Node(A,B,C);
			
			}
		Arrays.sort(edge, (a,b) -> (a.weight-b.weight));
		for(int i=0;i<E;i++) {
			if(find(edge[i].u) != find(edge[i].v)) {
				union(edge[i].u, edge[i].v);
				answer += edge[i].weight;
			}
				
		}
		System.out.println(answer);

	}


}
