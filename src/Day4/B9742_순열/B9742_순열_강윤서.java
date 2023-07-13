package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_강윤서 {
	static char [] arr; // 문자
	static int R; // 선택할 문자 개수
	static int [] select; // 선택한 문자 인덱스
	static boolean [] isSelected; // 선택한 문자 확인
	
	static int countCaseNum; // 현재 순열 위치
	static int findCaseNum; // 찾아야 하는 순열 위치
	
	static boolean result; // 결과
	static Character [] result_select; // 선택한 문자 인덱스
	
	public static void permutation(int r) {
		// 종료 조건
		if (r == R) {
			countCaseNum++; // 현재 순열 위치 업데이트
			if (countCaseNum == findCaseNum) { // 찾아야 하는 순열 위치이면 결과 저장
				result = true;
				for (int j=0; j<select.length; j++) // 선택한 문자 저장
					result_select[j] = arr[select[j]];
			};
			return;
		}
		// 재귀 확장
		for (int i=0; i<arr.length; i++) {
			// 이미 선택한 경우
			if (isSelected[i] == true) continue;
			
			// 아직 선택하지 않은 경우
			select[r] = i;
			isSelected[i] = true;
			permutation(r+1); // 순열 생성
			if (result==true) return; // 찾아야 하는 순열 위치 확인하면->더이상 순열 확인하지 않고 종료
			isSelected[i] = false; // 다음 순열을 만들기 위해 초기화
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = null;
		while ((str = br.readLine()) != null) { // 여러 개의 테스트 케이스
			st = new StringTokenizer(str);
			String origin = st.nextToken(); // 숫자 or 문자 입력
			findCaseNum = Integer.parseInt(st.nextToken()); // 찾아야 하는 순열 위치
			
			arr = origin.toCharArray();
			R = arr.length;
			select = new int[R];
			isSelected = new boolean[R];
			countCaseNum = 0;
			result = false;
			result_select = new Character[R];
			
			permutation(0);
			
			// 결과 출력
			if (result) {
				System.out.print(origin+" "+findCaseNum+" = ");
				for (int i=0; i<R; i++) {
					System.out.print(result_select[i]);
				}
			} else {
				System.out.print(origin+" "+findCaseNum+" = ");
				System.out.print("No permutation");
			}
			System.out.println();
		}
	}
}
