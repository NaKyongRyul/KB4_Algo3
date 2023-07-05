package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_Sol {
	
	static int L;
	static int C;
	static char [] arr;
	
	static StringBuilder builder;
	static boolean [] isSelected;
	
	static ArrayList <Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
	
	static boolean checkValid(StringBuilder builder) {
		
		int cnt_c = 0;
		int cnt_v = 0;
		
		char [] password = builder.toString().toCharArray();
		for(char c : password) {
			if(vowels.contains(c)) 
				cnt_v += 1;
			else 
				cnt_c += 1;	
			
			if(cnt_c >=2 && cnt_v >= 1 ) return true;		
		}
		return false;
		
	}
	
	static void combination(int r , int start) {
		
		if(r == L) {
			if(checkValid(builder))
				System.out.println(builder.toString());
			return;
		}
		
		for(int i=start; i<C; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			builder.append(arr[i]);
			combination(r+1 , i);
			isSelected[i] = false;
			builder.deleteCharAt(builder.length()-1);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		L = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(bf.readLine() , " ");
		arr = new char [C];
		for(int i=0; i<C; i++) arr[i] = token.nextToken().charAt(0);
		
		// 초기화 //
		builder = new StringBuilder();
		isSelected = new boolean [C];
		
		// arr 배열 정렬 => 사전순으로 표현하기 순열을 표현하기 위함
		Arrays.sort(arr);
		
		// 조합 이용
		combination(0,0);

	}
}
