package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12891_DNA비밀번호_강윤서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs = br.readLine();
		String [] str = strs.split(" ");
		
		int s = Integer.parseInt(str[0]); // 문자열 길이
		int p = Integer.parseInt(str[1]); // 비밀번호 부분 문자열 길이
		
		// 문자열
		String dnaList = br.readLine();
		
		// A, C, G, T 최소 개수
		strs = br.readLine();
		str = strs.split(" ");
		
		int [] minCount = new int[4];
		for (int i=0; i<4; i++) {
			minCount[i] = Integer.parseInt(str[i]);
		}
		
		// 슬라이딩 윈도우 초기화
		int result = 0; // 결과
		int [] curMinCount = {0, 0, 0, 0};
		char [] dna = {'A', 'C', 'G', 'T'};
		
		for (int i=0; i<p; i++) { // 비밀번호 부분 문자열 길이만큼 확인
			for (int j=0; j<4; j++) {// A, C, G, T 찾아서 개수 증가
				if (dnaList.charAt(i) == dna[j]) {
					curMinCount[j] += 1;
					break;
				}
			}
		}

		// 유효한지 확인
		boolean valid = true;
		for (int i=0; i<4; i++) {
			if (curMinCount[i]<minCount[i]) {
				valid = false;
			}
		}
		if (valid==true) result += 1;
		
		// 슬라이딩 윈도우 반복
		for (int i=1; i<s-p+1; i++) {
			char left = dnaList.charAt(i-1);
			for (int j=0; j<4; j++) {// A, C, G, T 찾아서 개수 감소
				if (left == dna[j]) {
					curMinCount[j] -= 1;
					break;
				}
			}
			
			char right = dnaList.charAt(i+p-1);
			for (int j=0; j<4; j++) {// A, C, G, T 찾아서 개수 증가
				if (right == dna[j]) {
					curMinCount[j] += 1;
					break;
				}
			}

			// 유효한지 확인
			valid = true;
			for (int j=0; j<4; j++) {
				if (curMinCount[j]<minCount[j]) {
					valid = false;
				}
			}
			if (valid==true) result += 1;			
		}
		System.out.println(result);
	}
}
