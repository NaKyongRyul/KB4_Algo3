package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_이우엽 {
	static int[] parent;
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 3
		int M = Integer.parseInt(br.readLine()); // 3
		int[][] arr2d = new int[N+1][N+1];
		parent = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
//		System.out.println(Arrays.toString(parent));
		
		StringTokenizer token;
		for(int i = 1; i < N+1; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < N+1; j++) {
				arr2d[i][j] = Integer.parseInt(token.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(arr2d));
		
		// 한행씩 순회하며 요소가 1일때 union
		for(int i = 0; i < arr2d.length; i++) {
			for(int j = 0; j < N+1; j++) {
				if(arr2d[i][j] == 1) {
					union(i, j);
				}
			}
		}
//		System.out.println(Arrays.toString(parent));
		
		token = new StringTokenizer(br.readLine(), " ");
		int std = 0;
		boolean flag = true;
		for(int i = 0; i < M; i++) {
			int cur = Integer.parseInt(token.nextToken());
			if(i == 0) std = cur;
			if(find(cur) != find(std)) {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("NO");
			return;
		} 
		System.out.println("YES");
	}
}
