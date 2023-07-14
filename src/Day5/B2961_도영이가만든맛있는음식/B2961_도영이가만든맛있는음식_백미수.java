package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2961_도영이가만든맛있는음식_백미수 {

	static int N; //재료 수
	static int R; //재료를 사용한 수
	static int S; //신 맛 *됨
	static int B; //쓴 맛 +됨
	static int min;
	
	static int[] arr1;// 뽑힌 재료의 신 맛 수열
	static int[] arr2;// 뽑한 재료의 쓴 맛 수열
	static int sum;
	static int mul;
	
	static int[] select;
	static boolean[] isSelected;
	
	public static int combination(int R,int idx, int size) {

		int dif = 0;
		
		//종료조건
		if(size == R) {
			sum = 0;
			mul = 1;
			for(int i =0; i < size; i++) {
				mul = arr1[select[i]] * mul;
				sum = arr2[select[i]] + sum;

				if(mul>sum) {
					dif = mul- sum;
				}else {
					dif = sum - mul;
				}
				if(dif<min) {
					min = dif;
				}
			}
			
			return min;
		}
		
		//확장
		for(int i = idx; i<arr1.length ;i++) {
			
			if(isSelected[i] == true) continue;	//선택된 자리가 있으므로 바로 반복문으로 넘어감
			
			select[size] = i;		//숫자를 뽑아준다.
			isSelected[i] = true;	//숫자를 뽑았으므로 그 자리를 true로 변경한다.
			combination(R,i, size+1);	
			
			isSelected[i] = false;
			
		}
		return min;

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		
		String[] str;
		arr1 = new int[N];
		arr2 = new int[N];
		for(int i =0; i<N; i++) {
			str = reader.readLine().split(" ");
			arr1[i] = Integer.parseInt(str[0]);
			arr2[i] = Integer.parseInt(str[1]);
			
		}
		
		min =1;
		int min1 =1;
		int min2 =0;
		for(int i =0; i<N; i++) {
			min1 = arr1[i]*min1;
			min2 = arr2[i]+min2;
			if(min1>min2) {
				min = min1;
			}else {
				min = min2;
			}
		}
		
		isSelected = new boolean[N];
		
		//재귀 실행
		for(int i =1 ;i<=N; i++) {
			R= i;
			select = new int[R];
			combination(R, 0, 0);
			
		}
		
		System.out.println(min);
	}
}
