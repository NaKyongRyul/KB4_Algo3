package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_Sol {

	// static 변수 //
	static char [] arr;		// 입력 문자열
	static int k;			// k 번째 수
	static int N;			// 배열의 크기
	static int cnt;			// 순열 개수 카운트
	static StringBuilder builder;		// 현재 결과를 확인하기위한 변수
	static boolean [] isSelected;		// 마킹배열
	
	
	//  순열 구현
	public static void permutation(int size) {

		// 종료 조건 도달 = 하나의 순열 만듬
		if(size == N) {
			if(++cnt == k ) {
				// 정답 출력
				System.out.println(String.valueOf(arr) + " " + k + " = " + builder.toString());
			}
//			System.out.println(builder.toString());
			return;
		}
		
		// 다음 재귀 확장
		for(int i=0; i<N; i++) {
			
			// 선택된 경우 = skip
			if(isSelected[i]) continue;
			
			// 선택
			isSelected[i] = true;
			builder.append(arr[i]);
			permutation(size + 1);
			
			// 선택 해제
			isSelected[i] = false;
			builder.deleteCharAt(builder.length()-1);
			
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str;


		// Test Case 개수가 정해져있지 않은 경우 = while 문으로 반복 // 
		while((str = in.readLine()) != null) {

			// 입력 처리 //
			String [] strs = str.split(" ");
			arr = strs[0].toCharArray();  		// char []
			k = Integer.parseInt(strs[1]);	

			// 초기화 //
			N = arr.length;
			builder = new StringBuilder();
			isSelected = new boolean [N];
			cnt = 0;
			
			// 순열 구현 //
			permutation(0);
			
			// 순열을 구성할수 없는 경우 
			if(k > cnt) System.out.println(String.valueOf(arr) + " " + k + " = No permutation");

		}


	}
}
