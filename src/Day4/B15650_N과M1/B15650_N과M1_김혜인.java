package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_김혜인 {
	// 중복 허용 X
	
	static int N;
	static int R;
	static int arr [];				// 결과 넣을 배열
	static int selection [];         // 현재 선택한 요소
	static boolean [] isSelected;     // 마킹배열 - 선택했는지 체크
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
		
        arr = new int[N];
		isSelected = new boolean[N];
		selection = new int[R];
		for(int i = 0; i<N; i++) 
			arr[i] = i+1;
		
		combination(0,0);
		System.out.println(sb);
	}
    
	public static void combination(int index, int count) {
		// TODO Auto-generated method stub
		if(count == R) {
	    	int x = 0;
	        for(int j=0; j<N; j++) {
	        	if(isSelected[j]) {
	        		sb.append(selection[x++]+ " ");
	        	}
	        }
	        sb.append('\n');
	    	return;
	    }
	    

	    //이미 고른수 선택 X : index부터 다시 선택해야함
	    for(int i=index; i<N; i++) {
	        if(!isSelected[i]) {       // 중복인 경우 skip
	        isSelected[i] = true;            // 중복 마킹
	        selection[count] = arr[i];               
	        combination(i+1, count+1);        // 다음 재귀로 가기전 +1Tlr 
	        isSelected[i] = false;  
	        // 이 수 사용하지 않음.	
	        }
	    }
}
	
}
