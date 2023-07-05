package Algo_day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_서은효 {
	static int N;
	static int M;
	static int [] arr;
	static int R;
	static int [] selection;
	static boolean[] isSelected;
	static void combination(int r, int start) {

		if( r == M ) {
			 for(int i=0; i<M; i++) System.out.print(arr[selection[i]]+1+" ");    // 결과 출력
		        System.out.println();
		        return;
		}
	    for(int i=start; i<N; i++) {
	        if(isSelected[i]) continue;        // 중복인 경우 skip
	        isSelected[i] = true;            // 중복 마킹
	        selection[r] = i;                // 선택
	        combination(r+1, i);                // 다음 재귀로
	        isSelected[i] = false;            // 선택한걸 되돌려줘야 함
	    }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		for(int i =0; i<N; i++)
			arr[i] = i;
		selection = new int [M];
		isSelected = new boolean[N];
		combination(0,0);
		

	}

}
