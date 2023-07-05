package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_박예린 {

	static int N, M;
	static int [] arr;
	static int [] select;
	static boolean [] isSelected;
	static StringBuilder stringBuilder = new StringBuilder();

	static void combination(int r, int start) {
		

		if(r == M) {
			for(int i = 0; i < M; i++) {
				stringBuilder.append(arr[select[i]]+1);
				if(i < M-1) stringBuilder.append(" ");
			}
			stringBuilder.append("\n");	
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = i;
			
		select = new int[M];
		isSelected = new boolean[arr.length];
		
		combination(0, 0);
		System.out.println(stringBuilder.toString());

		
		
	}

}
