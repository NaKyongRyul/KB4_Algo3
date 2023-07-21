package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1976_여행가자_오원식 {
	
	static int N;
	static int M;
	static int [] parent;
	static boolean res = true;
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);	
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x<y) parent[y] = x;
			else parent[x] = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i = 1; i <N+1; i++) {
			parent[i] = i;
		}
		
		//System.out.println(Arrays.toString(parent));
		
		for(int i = 1; i<N+1; i++) {
			String [] s = br.readLine().split(" ");
			for(int j = 1; j<N+1; j++) {
				if(s[0].equals("1")){
					union(i, j);	
				}
			}
			
		}
		
		String [] plan = br.readLine().split(" ");

		for(int i = 1; i<M; i++) {
			if(find(Integer.parseInt(plan[0])) != find(Integer.parseInt(plan[i]))){
				res = false;
			}
		}
		
		System.out.println(res ? "YES" : "NO");

	}

}
