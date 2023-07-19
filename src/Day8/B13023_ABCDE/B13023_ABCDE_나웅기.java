package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_나웅기 {
	static int n;
	static int m;
	static ArrayList<Integer> [] arr;
	static boolean [] visited;
	static int result;
	
	static void dfs(int x, int cnt) {
//		System.out.println(cnt);
		
		if (cnt == 5) {
			result = 1;
			return;
		}
		for (int i = 0; i<arr[x].size(); i++) {
			if (visited[arr[x].get(i)] == false) {
				visited[arr[x].get(i)] = true;
				dfs(arr[x].get(i), cnt+1);
				visited[arr[x].get(i)] = false;
			}
		}
		
		
 	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n];
		
		for (int i = 0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x].add(y);
			arr[y].add(x);
		}
		
		
		result = 0;
		for (int i = 0; i<n; i++) {
			visited = new boolean [n];
			visited[i] = true;
			dfs(i, 1);
			if (result == 1) {
				break;
			}
		}
		System.out.println(result);
	}
}
