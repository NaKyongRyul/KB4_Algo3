package Day5.B15650_N과M1;

package Day4;

import java.util.Scanner;

public class B15650_N과M1_Sol {

	
	static int N;
	static int M;
	
	static StringBuilder builder;	// 조합을 저장할 builder
	static boolean [] isSelected; 	// 선택 마킹 배열

	static void combination(int r , int start) {

		if(r==M) {
			System.out.println(builder.toString());
		}

		for(int i=start; i<N+1; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			builder.append(i + " ");
			combination(r+1 , i);
			isSelected[i] = false;
			builder.delete( builder.length()-2,  builder.length());
		}

	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		builder = new StringBuilder();
		isSelected = new boolean [N+1];
		
		combination(0 , 1);
		
	}

}
