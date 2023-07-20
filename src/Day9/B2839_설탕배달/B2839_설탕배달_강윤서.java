package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2839_설탕배달_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine()); // 설탕
		
		int[] bag = new int[5001]; // 각 설탕에 해당하는 봉지 개수 
		Arrays.fill(bag, -1); // 초기화 
		bag[3] = 1;
		bag[5] = 1;
		
		for (int i=6; i<sugar+1; i++) { // 설탕이 6~sugar일 때 봉지 개수 업데이트
			int five = bag[i-5];
			int three = bag[i-3];
			
			if (five==-1 && three==-1) { // 5kg 봉지 추가x and 3kg 봉지 추가x->kg 상관없이 모두 봉지 추가x
				bag[i] = -1;
			} else if (five==-1 || three==-1) { // 5kg 봉지 추가x or 3kg 봉지 추가x->kg 하나만 봉지 추가x
				bag[i] = Math.max(five, three)+1;
			} else if (five!=-1 && three!=-1) { // 5kg 봉지 추가o and 3kg 봉지 추가o->kg 상관없이 모두 봉지 추가o
				bag[i]=Math.min(five, three)+1;
			}
		}
		System.out.println(bag[sugar]);
	}
}
