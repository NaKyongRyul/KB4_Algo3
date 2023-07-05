package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합_박찬욱 {
	
	static int N; // 정수의 개수
	static int S; // 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값 중 원하는 값
	static int [] arr; // N개의 정수로 이루어진 수열
	static int ans; // S가 되는 경우의 수
	
	static boolean [] isSelected;
	
	// 수열을 부분집합으로 표현한 후, 
	// sum으로 합하여 S와 비교하여 같으면 ans에 1을 추가, ans 출력
	public static void subset(int num) {
		if(num == N) {
			int sum = 0; // 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += arr[i];
					flag = true; // 원소의 존재 여부 확인용
				}
			}
			if(sum  == S && flag == true) ans++; // sum = S이고, 원소가 존재하는 경우
			return;
		}
		
		isSelected[num] = true;
		subset(num+1);
		
		isSelected[num] = false;
		subset(num+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		
		arr = new int [N];
		token = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
			
		isSelected = new boolean [N];
		
		subset(0);
		
		System.out.println(ans); 
		
	}
}