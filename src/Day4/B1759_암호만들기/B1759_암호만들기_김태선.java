package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class B1759_암호만들기_김태선 {
	
	static int L, C;
	static char[]inputs;
	static char[] pwd;
	
	static boolean check(char[] pwd) {
		
		int j = 0; 
		int m = 0; 
		
		for (int i = 0; i < pwd.length; i++) {
			if( pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u') m++;
			else j++;
		}
		
		if(j >= 2 && m >= 1) return true; 
		else return false; 
	}
 
	
	static void combination(int cnt, int start) {
		
		if(cnt == L) {
			if(check(pwd)) { 
				for (char c : pwd) {  
					System.out.print(c);
				}
				System.out.println();
			}
			return; 
		}
		
		for (int i = start; i < C; i++) {
			pwd[cnt] = inputs[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		 
		inputs = new char[C]; 
		pwd = new char[L];
		
		for (int i = 0; i < C; i++) {
			inputs[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(inputs); 
		
		combination(0, 0); 
		
	}
}