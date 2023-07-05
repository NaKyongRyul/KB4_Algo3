package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9742_순열_박찬욱 {
	
	static char [] testCase; // 테스트 케이스를 char로 나누고 담아둔 배열
	static int N; // 나열된 순열중 알고 싶은 수열의 번호
	static int R; // 단어의 갯수
	
	static int [] selection; // 현재 선택한 요소
	static boolean [] isSelected; // 마킹배열 - 선택했는지 체크
	static int cnt; // 순열의 번호
	
	// 순열 //
	public static void permutation(int r) { // r : 순열의 시작점
		if(r == R) {
			if(++cnt == N) {
				System.out.print(String.valueOf(testCase) + " " + N + " = ");
				for(int i = 0; i < R; i++) {
					System.out.print(testCase[selection[i]]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = 0; i < R; i++) {
			if(isSelected[i]) continue;		// 중복인 경우 skip
			isSelected[i] = true;			// 중복 마킹
			selection[r] = i;				// 선택
			permutation(r+1);				// 다음 재귀로
			isSelected[i] = false;			// 선택한걸 되돌려줘야 함
		}
	}
			
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null; // 입력
		while ((input = bf.readLine()) != null) { // EOF( End of File) :  데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타내는 용어
			StringTokenizer token = new StringTokenizer(input, " ");
			testCase = token.nextToken().toCharArray(); // 테스트 케이스를 char로 변경 후 배열에 입력
			N = Integer.parseInt(token.nextToken()); // 알고 싶은 수열의 번호를 입력
			R = testCase.length; 
			
			cnt = 0;
			selection = new int [R];
			isSelected = new boolean [testCase.length];
			
			permutation(0);
			
			if(N > cnt) {
				System.out.print(String.valueOf(testCase) + " " + N + " = ");
				System.out.println("No permutation");
			}
		}
	}

}
