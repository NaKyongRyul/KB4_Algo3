package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9663_NQueen_곽승규 {

	static int N;
	static int [] arr;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N]; 
		
		DFS(0);
		System.out.println(count);

	}
	
	static void DFS(int depth) {
		if (depth == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			
			if(isPossible(depth)) {
				DFS(depth + 1);
			}
		}
	}
	
	static boolean isPossible(int depth) {
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth] || 
					(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))) {
				return false;
			}
		}
		
		return true;
	}
}
