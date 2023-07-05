package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int s = Integer.parseInt(token.nextToken()); // DNA 문자열 길이 |S|
		int p = Integer.parseInt(token.nextToken()); // 비밀번호로 사용할 부분문자열의 길이 |P|
		int ans = 0 ; // 만들 수 있는 비밀번호의 종류의 수
		int [] minArr = new int [4]; // 부분문자열에 포함되어야 할 {'A','C','G','T'} 의 최소 개수
		
		String str = bf.readLine(); // 민호가 임의로 만든 DNA 문자열
		char[] charArr = str.toCharArray(); // 문자열을 char 배열로 변경
		
		token = new StringTokenizer(bf.readLine(), " ");
		for(int i = 0; i < 4; i++) minArr[i] = Integer.parseInt(token.nextToken());
		
		int[] alphaArr = new int [4]; //  {'A','C','G''T'} 의 개수를 파악하기 위한 배열
		
		for(int i = 0; i < p; i++) { // 첫 번째 부분문자열의 {'A','C','G''T'} 의 개수 파악
			if(charArr[i] == 'A') alphaArr[0]++; 
			if(charArr[i] == 'C') alphaArr[1]++; 
			if(charArr[i] == 'G') alphaArr[2]++; 
			if(charArr[i] == 'T') alphaArr[3]++; 
		}
		
		// 조건 만족 여부 확인 -> 만족하면 ans 증가
		if(minArr[0] <= alphaArr[0] && minArr[1] <= alphaArr[1] 
				&& minArr[2] <= alphaArr[2] && minArr[3] <= alphaArr[3]) ans++;
		
		// 부분문자열 변경 -> 첫 번째 문자열의 문자 제외, 마지막 문자열에 문자 추가
		
		for(int i = p; i < s; i++) { // 마지막 문자열
			int j = i - p; // 첫번째 문자열
			
			// 첫 번째 문자열의 문자 제외
			if(charArr[j] == 'A') alphaArr[0]--; 
			if(charArr[j] == 'C') alphaArr[1]--; 
			if(charArr[j] == 'G') alphaArr[2]--; 
			if(charArr[j] == 'T') alphaArr[3]--;
			
			// 마지막 문자열에 문자 추가
			if(charArr[i] == 'A') alphaArr[0]++; 
			if(charArr[i] == 'C') alphaArr[1]++; 
			if(charArr[i] == 'G') alphaArr[2]++; 
			if(charArr[i] == 'T') alphaArr[3]++; 
			
			if(minArr[0] <= alphaArr[0] && minArr[1] <= alphaArr[1] 
					&& minArr[2] <= alphaArr[2] && minArr[3] <= alphaArr[3]) ans++;
		}
		
		System.out.println(ans);
	}
}