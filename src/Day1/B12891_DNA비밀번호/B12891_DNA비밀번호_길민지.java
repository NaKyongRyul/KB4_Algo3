package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_길민지 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// DNA 문자열 길이 S, 부분문자열 길이 P 입력
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// DNA 문자열 입력
		String dna = bf.readLine();
		
		// a, c, g, t 최소 개수 입력
		st = new StringTokenizer(bf.readLine());
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());
		
		int numA = 0, numC = 0, numG = 0, numT = 0;
		
		int result = 0;
		
		// 첫번째 부분문자열
		for (int i = 0; i<P; i++) {
			if (dna.charAt(i)=='A') numA ++;
			else if (dna.charAt(i)=='C') numC ++;
			else if (dna.charAt(i)=='G') numG ++;
			else numT ++;
		}
		if (minA<=numA && minC<=numC && minG<=numG && minT<=numT) result++;
		
		for (int i = 0; i<S-P; i++) {
			// 맨 앞 문자 빼기
			if (dna.charAt(i)=='A') numA --;
			else if (dna.charAt(i)=='C') numC --;
			else if (dna.charAt(i)=='G') numG --;
			else numT --;
			
			// 맨 뒤 문자 더하기
			if (dna.charAt(i+P)=='A') numA ++;
			else if (dna.charAt(i+P)=='C') numC ++;
			else if (dna.charAt(i+P)=='G') numG ++;
			else numT ++;
			if (minA<=numA && minC<=numC && minG<=numG && minT<=numT) result++;
		}
		System.out.println(result);
	}

}
