package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_조성환 {
	static int [] arr;
	static int N,M ; 
	static int [] selection;
	static boolean [] isVisited ;
	
	static void combination(int r, int start) {
		if (r == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[selection[i]] + " ");    
			}
	        System.out.println();
			return;
		}
		
		for (int i = start ; i < arr.length ; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			selection[r] = i;
			combination(r+1,i);
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N] ;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
		
		selection = new int [M];
		isVisited = new boolean [arr.length];
		
		combination(0,0);
	}


}
