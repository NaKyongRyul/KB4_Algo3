package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_박찬욱 {
	
	static int L; // 암호 자리수
	static int C; // 구성된 알파벳 개수
	static char [] alpha; // 구성 된 알파벳
	static String ans;

	static int [] select; // 현재 선택한 요소
	static boolean [] isSelected; // 선택했는지 체크
	
	public static void combination(int r, int start) {
		if(r == L) {
			int moeum = 0; // (a, e, i, o, u) <- 최소 한 개 필요
			int jaeum = 0; // 최소 두 개 필요
			ans = "";
			for(int i = 0; i < L; i++) {
				if(alpha[select[i]] == 'a' || alpha[select[i]] == 'e' || 
						alpha[select[i]] == 'i' || alpha[select[i]] == 'o' || alpha[select[i]] == 'u') {
					moeum++;
				}else {
					jaeum++;
				}
				ans += alpha[select[i]];
			}
			if(moeum >= 1 && jaeum >= 2) {
				System.out.println(ans);
			}
			return;
		}
		
		for(int i = start; i < alpha.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[r] = i;
			combination(r+1, i);		
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		
		alpha = new char [C];
		
		token = new StringTokenizer(bf.readLine());
		for(int i = 0; i < C; i++) {
			alpha[i] = token.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		select = new int [L];
		isSelected = new boolean [alpha.length];
		
		combination(0, 0);
	}

}
