package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_김태선 {
	
	public static int [] parent;
	
	public static int find(int x) {
	        if (x == parent[x]) {
	            return x;
	        }
	        return parent[x] = find(parent[x]);
	    }
	
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int [N + 1];
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int o = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(o == 0) {
				union(x, y);
			} else {
				if(find(x) == find(y)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
}