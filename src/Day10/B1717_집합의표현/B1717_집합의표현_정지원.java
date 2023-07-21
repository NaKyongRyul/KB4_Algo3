package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1717_집합의표현_정지원 {
static int[] parent;
	
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);
		}
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x<y) {
				parent[y] = x;
			}
			else {
				parent[x] = y;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		String input = br.readLine();
		n =	Integer.parseInt(input.split(" ")[0]);
		m = Integer.parseInt(input.split(" ")[1]);
		
		parent = new int[n+1];
		for(int i=0;i<n+1;i++) {
			parent[i] = i;
		}
		
		int a, b, cal;
		for(int i=0;i<m;i++) {
			input = br.readLine();
			cal = Integer.parseInt(input.split(" ")[0]);
			a = Integer.parseInt(input.split(" ")[1]);
			b = Integer.parseInt(input.split(" ")[2]);
			
			if(cal==0) {
				union(a, b);
			}
			else {
				if(find(a)==find(b)) System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}
