package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_백미수 {

	static int N; //N까지 자연수
	static int M; //뽑은 수
	static int[] arr; //뽑은 수열
	
	static int[] select; //선택된 arr인덱스
	static boolean[] isSelected;//선택된 수 뽑지 않도록 마킹
	
	private static void combination(int idx, int size) {
		
		//종료조건
		if(size == M) {
			
			for(int i =0; i < size; i++)
				System.out.print(arr[select[i]] + " ");
			System.out.println();
			
			return;
		}
		
		//확장
		for(int i = idx; i<arr.length ;i++) {
			
			if(isSelected[i] == true) continue;	//선택된 자리가 있으므로 바로 반복문으로 넘어감
			
			select[size] = i;		//숫자를 뽑아준다.
			isSelected[i] = true;	//숫자를 뽑았으므로 그 자리를 true로 변경한다.
			combination(i, size+1);	
			
			isSelected[i] = false;
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = reader.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		
		select = new int[M];
		isSelected = new boolean[N];
		
		//조합실행
		combination(0,0);
		
	}
	
}
