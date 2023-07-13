package Day4.B2750_퀵정렬;

public class PermutationTest {

	static char [] arr;
	static int N;
	static int R;
	static int [] select;
	static boolean [] isSelected;
	
	
	public static void permutation(int r) {
		
		// 종료조건
		if(r == R) {
			for(int i = 0; i<select.length; i++)
				System.out.print(arr[select[i]]);
			System.out.println();
			return;
		}
		
		// 재귀확장
		for(int i=0; i<arr.length; i++) {

			// 선택한 경우 = skip
			if(isSelected[i] == true) continue;
			
			// 선택
			select[r] = i;
			isSelected[i] = true;
			permutation(r+1); 
			
			// 선택 해제
			isSelected[i] = false;
		}
	}
	
	// 중복순열 = 중복허용
	public static void dup_permutation(int r) {
		
		// 종료조건
		if(r == R) {
			for(int i = 0; i<select.length; i++)
				System.out.print(arr[select[i]]);
			System.out.println();
			return;
		}
		
		// 재귀 확장
		for(int i = 0; i <arr.length; i++) {
			select[r] = i;			// 선택 저장
			dup_permutation(r+1); 	// 재귀 확장
		}
	}
	
	
	public static void main(String[] args) {
		
		arr = new char [] {'A' , 'B' , 'C' , 'D'};
		N = 4;
		R = 2;
		select = new int [R];
		isSelected = new boolean [arr.length];
		
		// 중복 순열
		System.out.println("### 중복 순열 ### ");
		dup_permutation(0);
		
		// 순열
		System.out.println("\n### 순열 ###");
		permutation(0);
	}
}
