package Day5.B15650_N과M1;
public class B15650_N과M_김대현 {

	// static 변수 //
	static char [] arr;
	static int N;		// 문자열 개수
	static int R;		// 선택개수
	
	static int [] select;	// 선택저장변수
	static boolean [] isSelected;	// 마킹배열
	
	public static void combination(int idx , int r) {
		
		// 종료조건
		if(r == R) {
			for(int i=0; i<R; i++) {
				System.out.print(arr[select[i]]); 
				System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀확장
		for(int i=idx; i<N; i++) {
			
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			select[r] = i;
			combination(i,r + 1);
			
			isSelected[i] = false;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		// 초기화 //
		arr = new char [] {'1' , '2' , '3' , '4'};
		N = arr.length;
		R = 2;
		select = new int [R];
		isSelected = new boolean [N];

		// 조합 실행 //
		combination(0,0);
		
		
	}
	
	
}