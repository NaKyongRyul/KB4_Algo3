package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_오원식 {
	
	static int [] select;	// 선택저장변수
	static boolean [] isSelected;	// 마킹배열
	
	public static void combination(int N, int M, int idx , int size) {
		
		// 종료조건
		if(size == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) 
				sb.append(select[i] + 1).append(" ");
			System.out.println(sb);
			return;
		}
		
		// 재귀확장
		for(int i=idx; i<N; i++) {
			
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			select[size] = i;
			combination(N, M, i, size + 1);
			
			isSelected[i] = false;
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String [] str = s.split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		select = new int [M];
		isSelected = new boolean [N];
		combination(N, M, 0, 0);

	}

}
