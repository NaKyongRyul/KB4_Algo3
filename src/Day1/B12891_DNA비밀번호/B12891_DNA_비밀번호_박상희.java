package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA_비밀번호_박상희 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int S = Integer.parseInt(token.nextToken());
		int P = Integer.parseInt(token.nextToken());
		
		String letters = bf.readLine();
		
		token = new StringTokenizer(bf.readLine(), " ");
		
		int numA = Integer.parseInt(token.nextToken());
		int numC = Integer.parseInt(token.nextToken());
		int numG = Integer.parseInt(token.nextToken());
		int numT = Integer.parseInt(token.nextToken());
		
		int answer = 0;
		int cnt[] = new int[4];
		
		// 첫 번째 부분 문자열 검사
		for (int i = 0; i < P; i++) {
			if (letters.charAt(i) == 'A') {
				cnt[0] += 1;
			}
			if (letters.charAt(i) == 'C') {
				cnt[1] += 1;
			}
			if (letters.charAt(i) == 'G') {
				cnt[2] += 1;
			}
			if (letters.charAt(i) == 'T') {
				cnt[3] += 1;
			}
		}
		
		if (cnt[0] >= numA && cnt[1] >= numC && cnt[2] >= numG && cnt[3] >= numT) {
			answer++;
		}
		
		
		int start = 0;
		while (start < S - P) { // 만들 수 있는 문자열 수만큼 검사
			// 전의 부분 문자열에서 빠진 문자 검사
			if (letters.charAt(start) == 'A') {
				cnt[0] -= 1;
			}
			if (letters.charAt(start) == 'C') {
				cnt[1] -= 1;
			}
			if (letters.charAt(start) == 'G') {
				cnt[2] -= 1;
			}
			if (letters.charAt(start) == 'T') {
				cnt[3] -= 1;
			}
			
			// 새롭게 들어올 문자 검사
			if (letters.charAt(start + P) == 'A') {
				cnt[0] += 1;
			}
			if (letters.charAt(start + P) == 'C') {
				cnt[1] += 1;
			}
			if (letters.charAt(start + P) == 'G') {
				cnt[2] += 1;
			}
			if (letters.charAt(start + P) == 'T') {
				cnt[3] += 1;
			}
			
			if (cnt[0] >= numA && cnt[1] >= numC && cnt[2] >= numG && cnt[3] >= numT) {
				answer++;
			}
			
			start++;
		}		
		
		System.out.println(answer);
	}
}
