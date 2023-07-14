package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_전민형 {

	static int [] arr;
	static int N;			//문자열 개수
	static int R;			//선택 개수
	
	static int [] select;    //선택 저장 변수
	static boolean [] isSelected;	//마킹배열
	
	public static void combination(int idx, int size) { //(idx추가)	이전의 뽑은 값보다 큰 값을 뽑아야 함
		
		//종료조건
		if(size == R) {
			for(int i = 0; i<R; i++) {
				System.out.print(arr[select[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx+1; i<N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			select[size] = i;
			combination(i, size+1);
			
			isSelected[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(reader.readLine());
		
		//초기화
		N = Integer.parseInt(str.nextToken());
		R = Integer.parseInt(str.nextToken());
		select = new int [R];
		isSelected = new boolean [N];
		
		arr = new int [N];
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		
		combination(-1,0);

	}

}
