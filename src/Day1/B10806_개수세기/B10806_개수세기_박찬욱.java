package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// 입력 처리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 정수의 개수
				
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
				
		int [] arr = new int [N]; // 배열된 N개의 정수
				
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
				
		int v = Integer.parseInt(bf.readLine()); // 찾으려는 정수
				
		// v 찾아서 카운트
		int ans = 0; // 찾으려는 정수의 개수
		for(int i = 0; i < N; i++) {
			if(v == arr[i]) ans++;
		}
				
		System.out.println(ans);

	}

}
