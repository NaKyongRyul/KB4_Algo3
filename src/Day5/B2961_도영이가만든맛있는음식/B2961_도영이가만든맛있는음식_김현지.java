package Day5.B2961_도영이가만든맛있는음식;

import java.util.Arrays;
import java.util.Scanner;


public class B2961_도영이가만든맛있는음식_김현지 {
	
	static char [] arr;				// 문자열 배열
	static int N;					// 배열 크기
	static boolean [] isSelected;	// 마킹 배열
	static int sour;
	static int bitter;
	static int score;
	static int [][] ingredients;
//	static int[][] ingredients = {{3,8},{5,8}};
	static int min ;
	static boolean usedIngredient = false;

	
	
	// 부분집합 구하는 재귀함수
	static void subSet(int n) {
		sour = 1;
		bitter = 0;
		// 종료조건
		if(n == N) {
//			System.out.println("isSelected: " + Arrays.toString(isSelected));
			for(int i=0; i<N; i++) {
//				System.out.println("i: "+i);
				if(isSelected[i]) {
//					System.out.println("Select 된 isSelected: " + Arrays.toString(isSelected));
					continue;
				}
				sour *= ingredients[i][0];
				bitter += ingredients[i][1];
				usedIngredient = true;
//				System.out.println("sour: " + sour);
//				System.out.println("bitter: " + bitter);
			}
			score = Math.abs(sour-bitter);
//			System.out.println("score: " + score + ", min: " + min);
			// 아무것도 먹지 않았을 때에 대한 에외처리 => 주의
			if (usedIngredient == true && score < min) {
				min = score;
//				System.out.println("min: "+min);
			}
			return;
		}
		
		// 재귀 확장 //
		
		// 1). 선택하는 경우
		isSelected[n] = true;
		subSet(n+1);
		
		// 2). 선택하지 않는 경우
		isSelected[n] = false;
		subSet(n+1);
		
	}
	
	
	public static void main(String[] args) {
		
		// 초기화
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		ingredients = new int [N][2];

		
		
		for (int i=0; i<N; i++) {
			String str = sc.nextLine();
			String [] strs = str.split(" ");
			ingredients[i][0] = Integer.parseInt(strs[0]);
			ingredients[i][1] = Integer.parseInt(strs[1]);
 		}
//		System.out.println(Arrays.deepToString(ingredients));
		
//		N=2;
		isSelected = new boolean [N];
		min = 1_000_000_000;
		subSet(0);
		System.out.println(min);
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


