package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_유유정 {
	
	static int N;   // 문자열 개수
	static int M;   //선택개수
	
	static int [] select ;  //선택저장변수
	static boolean []isSelected; //마킹배열
	
	public static void combination(int index, int size) {
		if(size == M) {
			for(int i=0;i<M;i++) {
				System.out.print(select[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=index;i<N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			select[size] = i+1;
			combination(i,size+1);
			
			isSelected[i] = false;
		}
			
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String [] strs01 = str.split(" ");
		N = Integer.parseInt(strs01[0]);
		M = Integer.parseInt(strs01[1]);
		select = new int [M];
		isSelected = new boolean[N];
		combination(0, 0);
	}

}
