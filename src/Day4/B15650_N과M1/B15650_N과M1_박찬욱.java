package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_박찬욱 {
	static int N; // 부터 N까지 자연수
	static int M; // 만족하는 길이 = R
	static int [] arr; // 1~N 자연수 배열
	
	static int [] select;
	static boolean [] isSelected;
	
	static void combination(int r, int start) {
		if(r == M){
			for(int i=0; i<M; i++) System.out.print(arr[select[i]] + " ");
			System.out.println();
			return;
		}
		
		for(int i = start; i < arr.length; i++) { 
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[r] = i;
			combination(r+1, i);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = bf.readLine();
			if(str == null) break;
			
			StringTokenizer token = new StringTokenizer(str, " ");
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			
			arr = new int [N]; 
			for(int i = 0; i < N; i++) arr[i] = i+1;
			
			select = new int [M];
			isSelected = new boolean [arr.length];
			
			combination(0, 0);
		}
	}
	
}