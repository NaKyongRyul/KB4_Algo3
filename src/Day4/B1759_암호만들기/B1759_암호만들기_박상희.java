package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_박상희 {
	static int N; // 암호의 글자 수
	static String[] pwd; // 암호로 쓸 전체 문자열 배열
	static int [] selection; // 선택한 암호 문자가 저장된 pwd 배열의 인덱스를 저장하는 배열
	static boolean [] isSelected; // 선택했는지 체크
	static String[] vowel = {"a", "e", "i", "o", "u"}; // 모음
	static String[] consonant; // 자음
	static int vowelCount; // 암호의 모음의 수
	static int consonantCount; // 암호의 자음의 수
	
	static void combination(int r, int start) {
		vowelCount = 0;
		consonantCount = 0;
		String str = "";

		if (r == N) {
			for (int i = 0; i < N; i++) {
				if (Arrays.asList(vowel).contains(pwd[selection[i]])) {
					vowelCount++;
				}
				else {
					consonantCount++;
				}
				
				str += pwd[selection[i]];
			}
			
			if (vowelCount >= 1 && consonantCount >= 2) {
				System.out.println(str);
			}
			
			return;
		}
		
		for (int i = start; i < pwd.length; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			combination(r + 1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int L = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());
		
		pwd = new String[C];
		token = new StringTokenizer(bf.readLine(), " ");
		for (int c = 0; c < C; c++) {
			pwd[c] = token.nextToken();
		}
		Arrays.sort(pwd);
		
		N = L;
		selection = new int[N];
		isSelected = new boolean[C];
		
		combination(0, 0);
	}
}
