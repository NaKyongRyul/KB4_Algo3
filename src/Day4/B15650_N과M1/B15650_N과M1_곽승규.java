package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650_N과M1_곽승규 {
	static int [] arr;
	static int R;
	static int [] selection;
	static boolean [] isVisited;
	static int N, M;
	
	static void combination(int r, int start) {
		if (r == R) {
			for(int i = 0; i < R; i++) System.out.print(selection[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			selection[r] = i+1;
			combination(r+1, i);
			isVisited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		R = M;
		selection = new int [R];
		isVisited = new boolean [N];
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		combination(0, 0);
	}

}
