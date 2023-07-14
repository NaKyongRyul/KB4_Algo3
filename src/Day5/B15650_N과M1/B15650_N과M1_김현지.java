package Day5.B15650_N과M1;

import java.util.Arrays;
import java.util.Scanner;

public class B15650_N과M1_김현지 {

	// static 변수 //
		static int [] arr;
		static int N;	// 문자열 개수
		static int R;	// 선택개수

		
		static int [] select;	 // 선택 저장 변수
		static boolean [] isSelected; 	// 마킹 배열
		
		public static void combination(int idx, int size) {

			// 종료조건
			if (size == R) {
				for(int i = 0; i<select.length; i++) {
					System.out.print(arr[select[i]] + " ");
				}
				System.out.println();
				return;
			}
			
			// 재귀확장
			for (int i=idx; i<N; i++) {			
				if (isSelected[i]) continue;
				
				isSelected[i] = true;
				select[size] = i;
				combination(i, size+1);
				
				isSelected[i] = false;
			}
		}
		
		
		public static void main(String[] args) {
			// 초기화
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			R = sc.nextInt();	
			arr = new int [N];
			for (int i=0; i<N; i++) {
				arr[i] = i+1;
			}


			
			select = new int [R];
			isSelected = new boolean [N];
			
			combination(0, 0);

		}
}
