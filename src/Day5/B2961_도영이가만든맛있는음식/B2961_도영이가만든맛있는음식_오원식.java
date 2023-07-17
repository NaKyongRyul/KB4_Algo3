package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2961_도영이가만든맛있는음식_오원식 {

	// static 변수 //

//	static ArrayList <StringBuilder>temp = new ArrayList<>();
	static int[] select; // 선택저장변수
	static boolean[] isSelected; // 마킹배열
	static int min = 1000000000;
	static int d;

	
	public static void combination(int [] S, int [] B, int N, int tmp, int idx , int size) {
			
			// 종료조건
			if(size == tmp) {

				int sour = 1;
				int bitter = 0;
						
				for(int i=0; i<tmp; i++) {
					sour *= S[select[i]];
					bitter += B[select[i]];
				}
				
//				if(sour>=bitter) d = sour-bitter;
//				else d = bitter-sour;
				
				d = (sour > bitter) ? sour - bitter : bitter - sour;
				
				if(min>d) min = d;
				return;
			}
			
			// 재귀확장
			for(int i=idx; i<N; i++) {
				
				if(isSelected[i]) continue;
				
				isSelected[i] = true;
				select[size] = i;
				combination(S, B, N, tmp, i, size + 1);
				
				isSelected[i] = false;
				
			}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] B = new int[N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			S[i] = Integer.parseInt(str[0]);
			B[i] = Integer.parseInt(str[1]);
		}
		
		for (int i = 0; i < N; i++) {
			select = new int[i+1];
			isSelected = new boolean[N];
			combination(S, B, N, i+1, 0, 0);
		}
		
		System.out.println(min);
	}

}
