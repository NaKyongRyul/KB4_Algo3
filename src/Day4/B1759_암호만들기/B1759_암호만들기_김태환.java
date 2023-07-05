package Day4.B1759_암호만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

	public class B1759_암호만들기_김태환 {
		static String [] arr;
		static int R;   				// 선택개수
		static int [] selection; 		// 현재 선택한 요소
		static boolean [] isSelected;
		static int cntmo=0;
		static int cntja=0;
	static void combination(int r , int start) {
		List<String> munja = new ArrayList<String>();
		if(r == R) {
			for(int i=0; i<R; i++) {
				munja.add(arr[selection[i]]);
			}// 결과 출력
			for(String str:munja) {
				if(str.equals("a")|str.equals("e")|str.equals("i")|str.equals("o")|str.equals("u")) {
					cntmo+=1;
				}
				else {
					cntja+=1;
				}
			}
			if(cntmo>=1 && cntja>=2) {
				for (String str:munja) {
					System.out.print(str);
				}
			
				cntmo=0;
				cntja=0;
//				System.out.println();
			}
			else {
				cntmo=0;
				cntja=0;
				return;
			}
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
	
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		int C=sc.nextInt();
		arr=new String [C];
		for(int i=0;i<C;i++) {
			arr[i]=sc.next();
		}
		Arrays.sort(arr);
		selection = new int [R];
		isSelected = new boolean [arr.length];

		combination(0,0);
		
	
}

}
