package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_이우엽 {
	static int[][] arr2d;
	static int N;
	static boolean[] isSelected;
	static boolean isCheck;
	static List<Integer> list = new ArrayList<>();
	public static void subset(int num) {
		// 종료조건
		if(num == N) {
			int sourPro = 1;
			int bitterSum = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					isCheck = true;
					sourPro *= arr2d[i][0];
					bitterSum += arr2d[i][1];
				}
			}
			
			if(!isCheck) {
				return;
			}
	
			list.add(Math.abs(sourPro-bitterSum));
			return;
		}
		
		// 재귀적 확장
		isSelected[num] = false;
		subset(num+1);
		
		isSelected[num] = true;
		subset(num+1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr2d = new int[N][2];
		isSelected = new boolean[N];
		
		// 재료의 개수 N만큼 신맛과 쓴맛을 입력
		for(int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			arr2d[i][0] = Integer.parseInt(token.nextToken()); // 신맛, *
			arr2d[i][1] = Integer.parseInt(token.nextToken()); // 쓴맛, +
		}
		
		subset(0);

		Collections.sort(list);
	
		System.out.println(list.get(0));
	}
}
