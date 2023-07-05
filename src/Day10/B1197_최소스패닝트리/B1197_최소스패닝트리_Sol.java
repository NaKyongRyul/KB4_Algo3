package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;
	
	Edge(int start , int end , int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "[" + this.start + "," + this.end + "," + this.weight + "]";
	}
	
}

public class B1197_최소스패닝트리_Sol {

	static int [] parent;
	
    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
 
    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		
		parent = new int [V+1];
		Arrays.setAll(parent, i->i);
		
		Edge [] edges = new Edge [E];
		
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(bf.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			edges[i] = new Edge(u,v,weight);
		}
		
		Arrays.sort(edges , (a,b) -> a.weight - b.weight);
		System.out.println(Arrays.toString(edges));
		
		int ans = 0;
		
		for(Edge now : edges) {
			if(find(now.start) != find(now.end)) {
				union(now.start , now.end);
				ans += now.weight;
			}
		}
		
		
		
		System.out.println(ans);
		
	}
}
