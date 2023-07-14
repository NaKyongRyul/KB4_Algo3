package Exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2 {
	
	static int[] arr;
	static boolean[] isSelected;
	static int R = 3; 				// nCr - n개 중 3개 고름
	static int[] selection;
	static int ans = 1;
	static int N; // 주어지는 숫자 개수
	static int M; // 최대 숫자 합
	
	static int sum = 0;
	
	static void combination(int now , int r) {
		
		if(r == R) { // r개의 숫자를 모두 골랐을 때 
			
			// M보다 작으면서 최댓값인지 확인
			if(sum<=M && sum>ans) 
				ans = sum;		// 최댓값 업데이트	
			
			return;
		}
		
		for(int i=now; i<N; i++) {
			if(isSelected[i]) continue; 
			isSelected[i] = true;
			selection[r] = i;
			sum += arr[i];
			combination(i , r+1);
			isSelected[i] = false;
			sum -= arr[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken()); // 주어지는 숫자 개수 
		M = Integer.parseInt(token.nextToken()); // 최대 숫자 합
		
		arr = new int[N];
		token = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		
		
		// 숫자 N개 중 세 개를 고르는 조합(중복 X)
		isSelected = new boolean[N]; 
		selection = new int[R];
		
		combination(0,0);
		
		System.out.println(ans); 
	}
}
