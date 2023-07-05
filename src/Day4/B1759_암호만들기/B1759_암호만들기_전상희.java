package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_전상희 {
	static char[] arr;
	static int[] selection;
	static boolean[] isSelected;
	static int L; // 암호의 글자수
	
	static void combination(int now, int start) {
		if(now==L) { // L개 선택 완료
			int cntV = 0; // 모음 카운트
			int cntC = 0; // 자음 카운트
			for(int i=0; i<L; i++) {
				char c = arr[selection[i]];
				if(c=='a' | c=='e' | c=='i' | c=='o' | c=='u') {
					cntV += 1;
				}
				else // 자음이 있는 경우
					cntC += 1;
				}
			
			if(cntV >= 1 && cntC >= 2) {
				for(int i=0; i<L; i++) System.out.print(arr[selection[i]]);
				System.out.println();
			}
			
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			selection[now] = i;
			combination(now+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());

		L = Integer.parseInt(token.nextToken()); // L 글자의 암호
		int C = Integer.parseInt(token.nextToken()); // 주어질 문자의 개수
		selection = new int[L];
		isSelected = new boolean[C];
		// 문자열 입력단
		arr = new char[C];
		String str = bf.readLine();
		int num = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!=' ') {
				arr[num++] = str.charAt(i);
			}
		}
		Arrays.sort(arr);
		combination(0, 0);
		// 조합의 경우의 수를 모두 구하면서 최소 한 개의 모음과 두 개의 자음이 들어갔는지 검사 후 출력
	}
}
