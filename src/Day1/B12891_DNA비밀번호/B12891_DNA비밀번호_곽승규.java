package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_곽승규 {

	public static void main(String[] args) throws IOException {
		int count = 0; // 정답 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		int S = Integer.parseInt(st.nextToken()); //dna 문자열 길이
		int P = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분 문자열 길이
		
		
		// DNA 문자열 입력
		String dna = br.readLine();
		
		// 이렇게하면 string을 char 배열로 할 수 있따. 
		//char [] dnaa = br.readLine().toCharArray();
		
		// A, C, G, T 개수 입력
		st = new StringTokenizer(br.readLine());
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());
		
		
		int [] check = {0,0,0,0}; // A, C, G, T 가 몇개 있는지 담을 배열 
		

		for (int i = 0; i < P; i++) {
			if (dna.charAt(i) == 'A') check[0]++;
			else if(dna.charAt(i) == 'C') check[1]++;
			else if(dna.charAt(i) == 'G') check[2]++;
			else check[3]++;
		}
		
		if (minA<=check[0] && minC<=check[1] && minG<=check[2] && minT<=check[3]) count++;
		
		
		// 슬라이딩 윈도우 실행
		for (int i = 0; i<S-P; i++) {
			
			// 맨 앞 문자 삭제
			if (dna.charAt(i)=='A') check[0] --;
			else if (dna.charAt(i)=='C') check[1] --;
			else if (dna.charAt(i)=='G') check[2] --;
			else check[3] --;
			
			// 맨 뒤 문자 추가
			if (dna.charAt(i+P)=='A') check[0] ++;
			else if (dna.charAt(i+P)=='C') check[1] ++;
			else if (dna.charAt(i+P)=='G') check[2] ++;
			else check[3] ++;
			
			if (minA<=check[0] && minC<=check[1] && minG<=check[2] && minT<=check[3]) count++;
		}
		System.out.println(count);
		
	}

}
