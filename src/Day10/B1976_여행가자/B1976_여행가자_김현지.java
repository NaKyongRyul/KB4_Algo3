package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_김현지 {
	static int [] parent;
	
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
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int [N+1];
		for (int i=0; i< N+1; i++) {
			parent[i] = i;
		}
		

		int connected;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				connected = Integer.parseInt(st.nextToken());
				if (connected == 1) {
					union(i+1,j+1);
				}
			}
		}
		
		// 도시 계획
		st = new StringTokenizer(br.readLine());
		int [] vacationPlan = new int [M];
		for (int i=0; i<M; i++) {
			vacationPlan[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean possible = true;
		if (vacationPlan.length != 1) {
			for (int i=0; i<M-1; i++) {
				if (find(vacationPlan[i]) != find(vacationPlan[i+1])) {
					possible = false;
				}
//				System.out.println(i + " " + possible);
			}
		}

		
		if (possible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
		

	}

}
