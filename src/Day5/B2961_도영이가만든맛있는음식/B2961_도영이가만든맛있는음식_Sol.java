package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MulticastSocket;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class B2961_도영이가만든맛있는음식_Sol {
	
	static int N;								// 배열의 크기
	static int [] S_arr;						// 재료 신맛 배열
	static int [] B_arr;						// 재료 쓴맛 배열
	static boolean [] isSelected;				// 탐색 마킹 배열
	static int nowS = 1;						// 현재 신맛
	static int nowB = 0;						// 현재 쓴맛
	static int ans = Integer.MAX_VALUE;			// 최솟값 저장 (정답)

	// 재료를 선택한게 있는지 없는지 확인하는 함수
	static boolean check_withIngredient() {
		for(int i=0; i<N; i++) {
			// 선택 O
			if(isSelected[i]) {
				return true;
			}
		}
		return false;
	}
	
	// 부분집합 탐색
	static void Search(int idx) {
		
		// 종료조건
		if(idx == N) {
			
			// 재료가 없는 경우 = skip
			if(!check_withIngredient()) return;
			
//			System.out.print("재료 : ");
//			for(int i=0; i<N; i++)
//				if(isSelected[i]) System.out.print(i + " ");
//			System.out.println("현재 최솟값 : " + ans);
			int diff = Math.abs(nowS - nowB);
			if(diff < ans) ans = diff;
			return;
		}
		
		// 다음 재귀
		// 1. 현재 원소 선택
		isSelected[idx] = true;
		nowS *= S_arr[idx];
		nowB += B_arr[idx];
		
		Search(idx + 1);
		
		// 선택 해제
		nowS /= S_arr[idx];
		nowB -= B_arr[idx];
		
		// 2. 현재 원소 선택 X
		isSelected[idx] = false;
		Search(idx + 1);
	}

	
	public static void main(String[] args) throws IOException {
		
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		S_arr = new int [N];
		B_arr = new int [N];
		isSelected = new boolean [N];
		
		for(int i=0; i<N; i++) 
		{
			String [] strs = bf.readLine().split(" ");
			S_arr[i] = Integer.parseInt(strs[0]);
			B_arr[i] = Integer.parseInt(strs[1]);
			isSelected[i] = true;
		}
		
		// 모든 경우의 수 (부분집합 탐색)
		Search(0);
		
		System.out.println(ans);
	}
}
