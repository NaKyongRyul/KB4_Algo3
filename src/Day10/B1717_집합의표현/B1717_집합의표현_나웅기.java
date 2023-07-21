package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_나웅기 {
	static int n;
	static int m;
	static int [] arr;
	static StringBuilder sb;
	static int find(int x) {
		if (x == arr[x]) return x;
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n+1];
		for (int i = 1; i<=n; i++) {
			arr[i] = i;
		}
		
		sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(reader.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (type == 0) {
				union(a, b);
			} else {
				if (find(a)==find(b)) {
					sb.append("YES" + "\n");
				} else {
					sb.append("NO" + "\n");
				}
			}
		}
		System.out.println(sb);
		
	}
}
