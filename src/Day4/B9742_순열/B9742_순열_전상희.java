package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_전상희 {
	static int count = 0;
	
	public static void permutation(char[] arr, int r, boolean[] isSelected, int[] selection, int N) {
		int len = arr.length;
		if(r==len) {	// 결과가 하나 생성될 때마다 count를 체크하고, count와 주어진 위치 N을 비교한다
			count++;
			if(count == N) {
				for(char c : arr) System.out.print(c);
				System.out.print(" " + N + " = ");
				for(int i=0; i<len; i++) System.out.print(arr[selection[i]]);
				System.out.println();
			}// N번째 순열 결과를 찾았을 때 print
			return;
		}
		
		for(int i=0; i<len; i++) {
			if(isSelected[i]) continue;
			// 중복된 문자를 뽑았을 경우 스킵
			isSelected[i] = true;
			selection[r] = i; 
			permutation(arr, r+1, isSelected, selection, N);
			isSelected[i] = false;
		} // 재귀 확장
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while((input = bf.readLine()) != null) {
			StringTokenizer token = new StringTokenizer(input);
			
			String str = token.nextToken(); // test case
			int N = Integer.parseInt(token.nextToken()); // 위치
			char[] arr = str.toCharArray(); // test case를 char 형의 배열로 바꿈
			
			int R = arr.length; // 배열의 길이(문자의 개수) 
			boolean[] isSelected = new boolean[R]; //문자 R개 들어오고, 중복되지 않게 R개 선택한다 
			int[] selection = new int[R];
			
			count = 0; // 순열의 위치를 확인하기 위한 변수
			
			permutation(arr, 0, isSelected, selection, N); 
			
			if(N>count) System.out.println(str + " " + N + " = No permutation");
			// N번째 순열을 못찾았을 때, 즉 N이 경우의 수보다 큰 경우 오류 메시지 출력
		}
	}
}
