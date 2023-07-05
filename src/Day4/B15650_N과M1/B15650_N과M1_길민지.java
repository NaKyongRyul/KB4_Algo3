package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_길민지 {
	static int N;
	static int M;
	static boolean isSelected[];
	static int select[];
	
	static void combination(int r, int start) {
		if (r == M) {
			for(int i=0; i<M; i++) System.out.print(select[i]+" ");
			System.out.println();
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (isSelected[i]==true) continue;
			isSelected[i] = true;
			select[r] = i+1;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N];
		select = new int[M];
		
		combination(0,0);
		
	}
}

