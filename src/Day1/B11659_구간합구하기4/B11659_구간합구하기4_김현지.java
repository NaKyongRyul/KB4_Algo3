package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_김현지 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// M, N
		String str = reader.readLine();
		String [] strs = str.split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		// 주어진 N개의 수
		String number = reader.readLine();
		String [] numberString = number.split(" ");
		
		int [] arr = new int [N];
		int len = numberString.length;
		for (int i=0; i<len; i++) {
			arr[i] = Integer.parseInt(numberString[i]);
		}
		
		// 구간 합 배열 생성
		int [] sum = new int[len];
		sum[0] = arr[0];
		for (int i=1; i<len; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		// from to
		int [] answer = new int[M];
		for (int j=0; j<M; j++) {
			String fromTo = reader.readLine();
			String [] fromTo1String = fromTo.split(" ");
			int from = Integer.parseInt(fromTo1String[0]);
			int to = Integer.parseInt(fromTo1String[1]);
			if (from == 1) {
				answer[j] = sum[to-1];
			} else {
				answer[j] = sum[to-1] - sum[from-2];
			}

		}
		
		for(int k=0; k<M; k++) {
			System.out.println(answer[k]);
		}
		


	}

}
