package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_박찬욱 {
	
	static int N; // 재료의 개수
	static int [] arrS; // 신맛
	static int [] arrB; // 쓴맛
	static int sPower; // 신맛의 총합 (전부다 곱)
	static int bPower; // 쓴맛의 총합 (전부다 합)
	static int min = Integer.MAX_VALUE;
	
	static boolean [] isSelected; 
	
	static void subset(int num) {
		// 종료조건
		if(num == N) {
			sPower = 1;
			bPower = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sPower *= arrS[i];
					bPower += arrB[i];
					if(min > Math.abs(sPower - bPower)) {
						min = Math.abs(sPower - bPower);
					}
				}
			}
				
			return;	
		}
		
		// 분할
		
		// 선택O
		isSelected[num] = true;
		subset(num+1);
		
		//선택X
		isSelected[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arrS = new int [N];
		arrB = new int [N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(bf.readLine());
			arrS [i] = Integer.parseInt(token.nextToken());
			arrB [i]= Integer.parseInt(token.nextToken());
		}
		
		isSelected = new boolean [N];
		
		subset(0);
		
		System.out.println(min);
	}

}
