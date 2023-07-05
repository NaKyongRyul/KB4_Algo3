package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_서은효 {
	static int [] checkArray = new int [4];
	static int [] min = new int [4];
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine()," ");
		
		//민호가 임의로 만든 DNA 문자열의 길이
		int S = Integer.parseInt(token.nextToken());
		//비밀번호로 사용할 부분문자열의 길이 
		int P = Integer.parseInt(token.nextToken());
		String[] arr = new String[S];
		
		token = new StringTokenizer(bf.readLine());
		String s = token.nextToken();
		
		//임의로 만든 문자열이 저장된 배열 
		for(int i =0 ;i< S; i++) {
			arr[i] = s.substring(i,i+1);
		}
		

		//만족해야하는 최소값이 저장된 배열 A,C,G,T
		token = new StringTokenizer(bf.readLine());
		for(int i =0;i<4;i++) {
			min[i] = Integer.parseInt(token.nextToken());
		}
		
		//부분 문자열 만큼 개수 카운트하고, 만족했다면 answer++		
		for(int i =0; i< S-P ;i++) {
			if(arr[i] == "A") checkArray[0]++;
			if(arr[i] == "C") checkArray[1]++;
			if(arr[i] == "G") checkArray[2]++;
			if(arr[i] == "T") checkArray[3]++;
		if(count()) {
			answer++;
		}
					
	}
		System.out.println(answer);
		
	}

	public static boolean count() {
		for(int i =0; i<4;i++) {
			if(min[i] > checkArray[i])
				return true;
		}
		return false;
	}
}
