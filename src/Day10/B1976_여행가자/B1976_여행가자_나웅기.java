package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_나웅기 {
	static int n;
	static int m;
	static int [] arr;
	
	static int find(int x) {
		if (x == arr[x]) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) arr[y] = x;
			else arr[x] = y;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		m = Integer.parseInt(reader.readLine());
		StringTokenizer st;
		arr = new int [n+1];
		for (int i = 1; i<=n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j<n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(arr[i+1], j+1);					
				}
			}
		}
		
		boolean flag = true;
		st = new StringTokenizer(reader.readLine());
		int check = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i<m; i++) {
			if (find(Integer.parseInt(st.nextToken())) != check) {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
