package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_나웅기 {
	static int N;
	static int M;
	static boolean [] visited;
	static int [] select;
	public static void combination(int idx, int size) {
		if (size == M) {
			for (int i = 0; i<M; i++) {
				System.out.print(select[i] + " ");
				
			}
			System.out.println();
			return;
		};
		
		for (int i = idx; i<N+1; i++) {
			if (visited[i] == true) continue;
			
			select[size] = i;
			visited[i] = true;
			combination(i+1,size+1);
			visited[i] = false;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		visited = new boolean [N+1];
		select = new int [M];
		combination(1,0);
	}
}
