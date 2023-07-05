package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1759_암호만들기_이우엽 {
	static int L;
	static int C;
	static char[] arr;
	static int[] selection;
	static boolean[] isSelected;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	
	public static void combination(int r, int start) {
		int vowelCnt = 0;
		int consoCnt = 0;
		//종료조건
		if(r == L) {
			String pwd = "";
			for(int i = 0; i < L; i++) {
				switch(arr[selection[i]]) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						vowelCnt++;
						break;
					default:
						consoCnt++;
				}
				pwd += arr[selection[i]];
			}
			if(vowelCnt >= 1 && consoCnt >= 2) {
				System.out.println(pwd);
			}
			return;
		}
		//재귀적확장
		for(int i = start; i < arr.length; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			selection[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new char[C];
		selection = new int[L];
		isSelected = new boolean[arr.length];
		
		token = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) {
			arr[i] = token.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		combination(0,0);
	}

}
