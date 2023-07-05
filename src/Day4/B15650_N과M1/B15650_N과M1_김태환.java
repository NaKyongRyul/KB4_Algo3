package Day4.B15650_N과M1;

import java.util.Scanner;

public class B15650_N과M1_김태환 {

		static int [] arr;
		static int R;   				// 선택개수
		static int [] selection; 		// 현재 선택한 요소
		static boolean [] isSelected; 	// 마킹배열 - 선택했는지 체크

		static void combination(int r , int start) {

			if(r == R) {
				for(int i=0; i<R; i++) System.out.print(arr[selection[i]]+" ");	// 결과 출력
				System.out.println();
				return;
			}

			for(int i=start; i<arr.length; i++) {
				if(isSelected[i]) continue;		// 중복인 경우 skip
				isSelected[i] = true;			// 중복 마킹
				selection[r] = i;				// 선택
				combination(r+1 , i );				// 다음 재귀로
				isSelected[i] = false;			// 선택한걸 되돌려줘야 함
			}
		}


		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int N = sc.nextInt();
			arr = new int[N];
			for (int i=0;i<N;i++) {
			arr[i]=i+1;}
			R = sc.nextInt();
			selection = new int [R];
			isSelected = new boolean [arr.length];

			combination(0,0);

		}
	}